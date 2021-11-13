package com.cherepnin.smartfridge.model;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private String name;
    private ProductType productType;
    private double price;

    public Product(String name, ProductType productType, double price) {
        this.name = name;
        this.productType = productType;
        this.price = price;
    }

    public static Product createProduct(String name, ProductType productType, double price) {
        return new Product(name, productType, price);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("[name: ").append(name)
                .append(", price: ").append(price)
                .append(']').toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    public String getName() {
        return name;
    }

    public ProductType getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Product o) {
        return this.name.compareTo(o.name);

    }
}
