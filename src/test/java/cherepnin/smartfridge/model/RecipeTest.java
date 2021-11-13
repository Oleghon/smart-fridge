package cherepnin.smartfridge.model;

import com.cherepnin.smartfridge.model.Product;
import com.cherepnin.smartfridge.model.ProductType;
import com.cherepnin.smartfridge.model.Recipe;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RecipeTest {

    static Recipe recipe;

    @Before
    public void init() {
        recipe = new Recipe("Test", new HashMap<Product, Integer>() {
            {
                put(new Product("prod1", ProductType.MEAT, 11.1d), 1);
                put(new Product("prod2", ProductType.MEAT, 11.1d), 1);
                put(new Product("prod3", ProductType.MEAT, 11.1d), 1);
                put(new Product("prod4", ProductType.MEAT, 11.1d), 1);
                put(new Product("prod5", ProductType.MEAT, 11.1d), 1);
            }
        });
    }

    @Test
    public void shouldReturnCorrectName() {
        String expected = "Test";
        String actual = recipe.getName();
        Assert.assertSame(expected, actual);
    }

    @Test
    public void shouldReturnCorrectMap() {
        Map<Product, Integer> expected = new HashMap<>() {{
            put(new Product("prod1", ProductType.MEAT, 11.1d), 1);
            put(new Product("prod2", ProductType.MEAT, 11.1d), 1);
            put(new Product("prod3", ProductType.MEAT, 11.1d), 1);
            put(new Product("prod4", ProductType.MEAT, 11.1d), 1);
            put(new Product("prod5", ProductType.MEAT, 11.1d), 1);
        }};
        Map<Product, Integer> actual = recipe.getProducts();
        Assert.assertEquals(expected, actual);
    }
}
