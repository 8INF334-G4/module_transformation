package org.groupe4;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.groupe4.mock.MockDDD;

public class DDDWriter implements OutputWriter {
    private MockDDD mockDDD;

    public DDDWriter(MockDDD mockDDD) {
        this.mockDDD = mockDDD;
    }

    @Override
    public void writeNext(Product product) {
        ArticleExternalInterface article = ArticleExternalInterface.ProductMapper.INSTANCE.toExternal(product);
        mockDDD.WriteReport(article);
    }
}
