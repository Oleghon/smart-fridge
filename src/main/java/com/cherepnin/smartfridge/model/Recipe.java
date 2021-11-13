package com.cherepnin.smartfridge.model;

import java.util.Map;

public class Recipe {
    private String name;
    private Map<Product, Integer> products;

    public Recipe(String name, Map<Product, Integer> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return new StringBuilder("Recipe{")
                .append("name: '").append(name)
                .append(", products: ").append(products)
                .append('}').toString();
    }
}
