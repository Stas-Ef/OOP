package org.skypro.skyshop.product;

import org.skypro.skyshop.Exception.NameIsBlankException;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;

    public FixPriceProduct(String productName) throws NameIsBlankException {
        super(productName);
    }


    @Override
    public double getProductCost() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return getproductName() + " с фиксированной ценой: Фиксированная цена " + getProductCost();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
