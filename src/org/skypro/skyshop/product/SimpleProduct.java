package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    int productCoast;

    public SimpleProduct(String productName, int productCoast) {
        super(productName);
        this.productCoast = productCoast;
    }

    @Override
    public double getProductCoast() {
        return productCoast;
    }

    @Override
    public String toString() {
        return getproductName() + ": " + getProductCoast();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
