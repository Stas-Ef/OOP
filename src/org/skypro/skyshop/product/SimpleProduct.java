package org.skypro.skyshop.product;

import org.skypro.skyshop.Exception.NameIsBlankException;

import java.util.Objects;

public class SimpleProduct extends Product {
    private int productCoast;

    public SimpleProduct(String productName, int productCoast) throws IllegalArgumentException, NameIsBlankException {
        super(productName);
        if (productCoast < 1) {
            throw new IllegalArgumentException("Введена неверная цена продукта " + productName + " Введенная цена: " + productCoast);
        }
        this.productCoast = productCoast;

    }

    @Override
    public double getProductCost() {
        return productCoast;
    }

    @Override
    public String toString() {
        return getproductName() + ": " + getProductCost();
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        SimpleProduct that = (SimpleProduct) object;
        return productCoast == that.productCoast;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productCoast);
    }
}
