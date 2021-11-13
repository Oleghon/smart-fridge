package cherepnin.smartfridge.model;

import com.cherepnin.smartfridge.model.Product;
import com.cherepnin.smartfridge.model.ProductType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {

    static Product product;

    @Before
    public void init() {
        product = new Product("test", ProductType.MEAT, 111.1d);
    }

    @Test
    public void shouldReturnNewProduct(){
    Product expected = product;
    Product actual = new Product("test", ProductType.MEAT, 111.1d);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDifferentProducts() {
        Product unexpected = product;
        Product actual = new Product("tomato", ProductType.VEGETABLE, 111.1d);
        Assert.assertNotSame(unexpected, actual);
    }

    @Test
    public void shouldReturnDifferentName(){
        String unexpected = product.getName();
        Product actual = new Product("tomato", ProductType.VEGETABLE, 111.1d);
        Assert.assertNotSame(unexpected, actual.getName());
    }

    @Test
    public void shouldReturnTrue(){
        Product expected = product;
        Product actual = new Product("test", ProductType.MEAT, 111.1d);
        Assert.assertTrue(expected.equals(actual));
    }
}
