package test;

import java.util.List;

public class ShoppingBasketImpl implements ShoppingBasket {

    private final static String APPLE = "apple";
    private final static String ORANGE = "orange";
    private final static float APPLE_PRICE = 0.60f;
    private final static float ORANGE_PRICE = 0.25f;

    @Override
    public float checkout(List<String> productList) {
        if (productList == null || productList.isEmpty())
            return 0.0f;
        int apples = 0;
        int oranges = 0;
        for (String s : productList) {
            if (s.equalsIgnoreCase(APPLE))
                apples++;
            else if (s.equalsIgnoreCase(ORANGE))
                oranges++;
        }

        return calculatePrice(apples, APPLE_PRICE, getApplePriceCalculator())
                + calculatePrice(oranges, ORANGE_PRICE, getOrangePriceCalculator());
    }

    protected PriceCalculator getApplePriceCalculator() {
        PriceCalculator pc = (q, p) -> ((q / 2) * p) + ((q % 2) * p);
        return pc;
    }

    protected PriceCalculator getOrangePriceCalculator() {
        PriceCalculator pc = (q, p) -> ((q / 3) * p * 2) + ((q % 3) * p);
        return pc;
    }

    private float calculatePrice(int quantity, float price, PriceCalculator pc) {
        return pc.calculatePrice(quantity, price);
    }

}
