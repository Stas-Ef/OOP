package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
   private int basicCoast;
    private int discount;

    public DiscountedProduct(String productName, int basicCoast, int discount) {
        super(productName);
        this.basicCoast = basicCoast;
        this.discount = discount;
    }

    @Override
    public double getProductCoast() {

        return  basicCoast * (1 - discount / 100.0);
    }

    @Override
    public String toString() {
        return getproductName() + " со скидкой: " + getProductCoast() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

}
