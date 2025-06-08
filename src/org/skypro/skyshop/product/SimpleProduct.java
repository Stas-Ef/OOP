package org.skypro.skyshop.product;

import org.skypro.skyshop.Exception.NameIsBlankException;

public class SimpleProduct extends Product {
    private int productCoast;

    public SimpleProduct(String productName, int productCoast) throws IllegalArgumentException, NameIsBlankException {
        super(productName);
        if (productCoast < 1) {
            throw new IllegalArgumentException("Введена неверная цена продукта " + productName + " Введенная цена: " + productCoast);
        } else {
            this.productCoast = productCoast;
        }
    }

    @Override
    public double getProductCoast() {
        return productCoast;
    }

    @Override
    public String toString() {
        return getproductName() + ": " + getProductCoast();
    }


}
