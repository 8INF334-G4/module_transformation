package org.groupe4;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private Map<String, String> attributes;

    public Product() {
        attributes = null;
    }

    public Product(String name, int price) {
        attributes = Map.of("name", name, "price", Integer.toString(price));
    }

    public String getAttribute(String key) {
        if (attributes == null) {
            return null;
        }
        return attributes.get(key);
    }

     public void setAttribute(String key, String value) {
        if (attributes == null) {
            attributes = new HashMap<>();
        }
        attributes.put(key, value);
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
