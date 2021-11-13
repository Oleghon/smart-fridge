package com.cherepnin.smartfridge;

import com.cherepnin.smartfridge.model.*;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Product, Integer> productIntegerMap = new HashMap<>() {{
            put(new Product("яловичина", ProductType.VEGETABLE, 150.60), 2);
            put(new Product("помаранч", ProductType.FRUIT, 35.3), 4);
            put(new Product("молоко", ProductType.MILK, 25.60), 2);
            put(new Product("огірок", ProductType.VEGETABLE, 35.20), 2);
            put(new Product("куриця", ProductType.MEAT, 120.60), 3);
        }};
        Fridge fridge = new Fridge(productIntegerMap);

        Recipe recipe = new Recipe("Олів'є", new HashMap<>() {{
            put(new Product("горошек", ProductType.VEGETABLE, 150.60), 2);
            put(new Product("майонез", ProductType.SOUSE, 15.3), 4);
            put(new Product("картопля", ProductType.VEGETABLE, 22.60), 2);
            put(new Product("огірок", ProductType.VEGETABLE, 35.20), 3);
            put(new Product("куриця", ProductType.MEAT, 120.60), 2);
        }});

        fridge.addProduct("огірок", ProductType.VEGETABLE, 35.20, 4);
        fridge.createShoppingList(recipe.getProducts());
        System.out.println(fridge.showShoppingList());
        System.out.println(fridge.showAvailableProducts());

    }
}

