package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    ShoppingBasket basket = new ShoppingBasketImpl();

    @Test
    public void testNullList(){
        float result = basket.checkout(null);
        assertEquals(0.0f,result,0.1);
    }

    @Test
    public void testEmptyList(){
        float result = basket.checkout(new ArrayList<String>());
        assertEquals(0.0f,result,0.1);
    }
    @Test
    public void testCheckout(){
        List<String> productList = new ArrayList();
        productList.add("Apple");
        productList.add("Apple");
        productList.add("Orange");
        productList.add("Apple");
        float result = basket.checkout(productList);
        assertEquals(2.05f,result,0.01);
    }

    @Test
    public void testInvalidProduct(){
        List<String> productList = new ArrayList();
        productList.add("Apple");
        productList.add("Apple");
        productList.add("Orange");
        productList.add("Apple");
        productList.add("Banana"); // Banana should be ignored
        float result = basket.checkout(productList);
        assertEquals(2.05f,result,0.01);
    }

}
