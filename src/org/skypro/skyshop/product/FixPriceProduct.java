package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;

    public FixPriceProduct(String productName) {
        super(productName);
    }


    @Override
    public double getProductCoast() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return getproductName() + " с фиксированной ценой: Фиксированная цена " + getProductCoast();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
