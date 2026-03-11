package org.groupe4;

import java.util.HashMap;
import java.util.Map;

public class Product {
    private Map<String, String> _attributes;

    public Product() {
        _attributes = null;
    }

    public Product(String name, int price) {
        _attributes = Map.of("name", name, "price", Integer.toString(price));
    }

    public String getAttribute(String key) {
        if (_attributes == null) {
            return null;
        }
        return _attributes.get(key);
    }

     public void setAttribute(String key, String value) {
        if (_attributes == null) {
            _attributes = new HashMap<>();
        }
        _attributes.put(key, value);
    }
}
