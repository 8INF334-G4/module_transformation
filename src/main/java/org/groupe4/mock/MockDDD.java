package org.groupe4.mock;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import org.groupe4.Product;
import org.groupe4.Logger;
import org.groupe4.ArticleExternalInterface;

public class MockDDD {
    public MockDDD() {

    }

    public void WriteReport(ArticleExternalInterface article) {
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = xmlMapper.writeValueAsString(article);
            Logger.getInstance().info("Generated XML: " + xml);
        } catch (Exception e) {
            Logger.getInstance().exception(e);
        }
    }
}
