package test;

import java.util.List;

public class ShoppingBasketImpl implements ShoppingBasket {

    private final static String APPLE = "apple";
    private final static String ORANGE = "orange";
    private final static float APPLE_PRICE = 0.60f;
    private final static float ORANGE_PRICE = 0.25f;

    public float checkout(List<String> productList) {
        if(productList==null || productList.isEmpty())
            return 0.0f;
        int apples = 0;
        int oranges = 0;
        for (String s : productList) {
            if (s.equalsIgnoreCase(APPLE))
                apples++;
            else if (s.equalsIgnoreCase(ORANGE))
                oranges++;
        }

        return apples * APPLE_PRICE + oranges * ORANGE_PRICE;
    }

}
