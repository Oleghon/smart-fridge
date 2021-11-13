package cherepnin.smartfridge.model;

import com.cherepnin.smartfridge.model.Fridge;
import com.cherepnin.smartfridge.model.Product;
import com.cherepnin.smartfridge.model.ProductType;
import com.cherepnin.smartfridge.model.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FridgeTest {

    static Fridge fridge;
    static Recipe recipe;

    @Before
    public void init() {
        fridge = new Fridge(new HashMap<Product, Integer>() {
            {
                put(new Product("prod1", ProductType.MEAT, 11.1d), 1);
                put(new Product("prod2", ProductType.MEAT, 11.1d), 1);
                put(new Product("prod3", ProductType.MEAT, 11.1d), 1);
                put(new Product("prod4", ProductType.MEAT, 11.1d), 1);
                put(new Product("prod5", ProductType.MEAT, 11.1d), 1);
            }
        });
        recipe = new Recipe("Test", new HashMap<Product, Integer>() {
            {
                put(new Product("prod1", ProductType.VEGETABLE, 11.1d), 1);
                put(new Product("prod2", ProductType.FRUIT, 11.1d), 2);
                put(new Product("prod3", ProductType.SOUSE, 11.1d), 3);
                put(new Product("prod4", ProductType.MILK, 11.1d), 4);
            }
        });
    }

    @Test
    public void shouldReturnExceptionWhenShoppingListDidNotCreate() {
        Assert.assertThrows(NullPointerException.class, () -> fridge.showShoppingList());
    }

    @Test
    public void shouldReturnCorrectShoppingList() {
        String expected = "1. prod2(2шт.): 11.1грн.\n2. prod4(4шт.): 11.1грн.\n3. prod3(3шт.): 11.1грн.\nСума: 99,9грн.";
        fridge.createShoppingList(recipe.getProducts());
        String actual = fridge.showShoppingList();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewMap() {
        Map<Product, Integer> unexpected = recipe.getProducts();
        Map<Product, Integer> actual = fridge.createShoppingList(recipe.getProducts());
        Assert.assertNotSame(unexpected, actual);
    }

    @Test
    public void shouldReturnCountFour() {
        int expected = 4;
        int actual = fridge.addProduct("prod1", ProductType.MEAT, 11.1d, 3);
        Assert.assertEquals(expected, actual);
    }
}
