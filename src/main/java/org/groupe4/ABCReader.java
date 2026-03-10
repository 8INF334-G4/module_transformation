package org.groupe4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.groupe4.mock.MockABC;

import java.util.Map;

public class ABCReader implements InputReader {
    private MockABC _mockABC;
    private int _currentId = 0;

    public ABCReader(MockABC mockABC) {
        _mockABC = mockABC;
        _currentId = 0;
    }

    public ABCReader(MockABC mockabc, int startId) {
        _mockABC = mockabc;
        _currentId = startId;
    }

    @Override
    public Product read(int id) {
        Product product = new Product();
        String report = _mockABC.GenerateReport(id);

        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode rootNode = mapper.readTree(report);
            rootNode.fields().forEachRemaining(elt -> {
                product.setAttribute(elt.getKey(), elt.getValue().asText());
            });
        } catch (Exception e) {
            throw new RuntimeException("Failed to read product " + id);
        }
        return product;
    }

    @Override
    public Product readNext() {
        return read(_currentId++);
    }
}
