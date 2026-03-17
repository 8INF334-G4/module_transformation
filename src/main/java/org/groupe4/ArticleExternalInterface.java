package org.groupe4;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import java.util.Map;

import org.groupe4.Product;

public class ArticleExternalInterface {
    @Mapper
    public static interface ProductMapper {
        ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

        @Mapping(target = "name", source = "attributes", qualifiedByName = "mapAttributesToName")
        @Mapping(target = "price", source = "attributes", qualifiedByName = "mapAttributesToPrice")
        @Mapping(target = "infos", source = "attributes", qualifiedByName = "mapAttributesToInfos")
        ArticleExternalInterface toExternal(Product product);

        @Named("mapAttributesToName")
        default String mapAttributesToName(Map<String, String> attributes) {
            if (attributes == null) throw new IllegalArgumentException("Attributes map is null");
            String name = attributes.getOrDefault("name", attributes.get("nom"));
            if (name == null) throw new IllegalArgumentException("Attributes must contain a 'name' or 'nom' key");
            return name;
        }

        @Named("mapAttributesToPrice")
        default float mapAttributesToPrice(Map<String, String> attributes) {
            if (attributes == null) throw new IllegalArgumentException("Attributes map is null");
            String price = attributes.getOrDefault("price", attributes.get("prix"));
            if (price == null) throw new IllegalArgumentException("Attributes must contain a 'price' or 'prix' key");
            return Float.parseFloat(price);
        }

        @Named("mapAttributesToInfos")
        default Map<String, String> mapAttributesToInfos(Map<String, String> attributes) {
            if (attributes == null) {
                return Map.of();
            }
            return attributes.entrySet().stream()
                    .filter(entry -> !entry.getKey().equals("name") && !entry.getKey().equals("nom") &&
                                     !entry.getKey().equals("price") && !entry.getKey().equals("prix"))
                    .collect(java.util.stream.Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        }
    }


    private String name;
    private float price;
    private Map<String, String> infos;

    public ArticleExternalInterface() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Map<String, String> getInfos() {
        return infos;
    }

    public void setInfos(Map<String, String> infos) {
        this.infos = infos;
    }
}
