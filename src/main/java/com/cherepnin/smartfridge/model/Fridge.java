package com.cherepnin.smartfridge.model;

import java.text.DecimalFormat;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fridge {
    private Map<Product, Integer> shoppingList;
    private Map<Product, Integer> availableProducts;

    public Fridge(Map<Product, Integer> availableProducts) {
        this.availableProducts = availableProducts;
    }

    // метод додає продукт у холодильник
    public int addProduct(String name, ProductType type, double price, int count) {
        Product product = Product.createProduct(name, type, price);

        if (availableProducts.keySet().contains(product))
            count += availableProducts.get(product);
        availableProducts.put(product, count);
        return availableProducts.get(product);
    }

    // метод виводить список продуктів що знаходяться у холодильнику
    public String showAvailableProducts() {
        StringBuilder sb = new StringBuilder("Продукти в холодильнику:\n");
        int count = 1;
        for (Map.Entry<Product, Integer> entry : availableProducts.entrySet()) {
            sb.append(count++).append(". ")
                    .append(entry.getKey().getName())
                    .append(' ').append(entry.getValue()).append("шт.\n");
        }
        return sb.toString();
    }

    // метод створює список продуктів що треба придбати на основі рецепту та продуктів що є у холодильнику
    public Map<Product, Integer> createShoppingList(Map<Product, Integer> map1) {
        shoppingList = Stream.of(map1).flatMap(m -> m.entrySet().stream())
                .filter((m1) -> m1.getValue().intValue() > availableProducts.getOrDefault(m1.getKey(), 0))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Math::max));
        return shoppingList;
    }

    // метод виводить список продуктів що треба придбати та розраховує загальну вартість продуктів із списку
    public String showShoppingList() {
        int count = 1;
        double resultPrice = 0.d;
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Product, Integer> entry : shoppingList.entrySet()) {
            resultPrice += entry.getKey().getPrice() * entry.getValue();
            sb.append(count++).append(". ")
                    .append(entry.getKey().getName())
                    .append('(').append(entry.getValue()).append("шт.): ")
                    .append(entry.getKey().getPrice()).append("грн.\n");
        }
        return sb.append("Сума: ").append(new DecimalFormat("###.##").format(resultPrice)).append("грн.").toString();
    }
}
