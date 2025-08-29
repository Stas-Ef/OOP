package org.skypro.skyshop.product;

import org.skypro.skyshop.Exception.DiscountPriceException;
import org.skypro.skyshop.Exception.NameIsBlankException;

import java.util.Objects;


public class DiscountedProduct extends Product {
    private int basicCoast;
    private int discount;

    public DiscountedProduct(String productName, int basicCoast, int discount) throws DiscountPriceException, IllegalArgumentException, NameIsBlankException {
        super(productName);
        if (basicCoast < 1) {
            throw new IllegalArgumentException("Введена неверная цена продукта " + productName + " Введенная цена: " + basicCoast);
        }
        this.basicCoast = basicCoast;
        if (discount < 0 || discount > 100) {
            throw new DiscountPriceException("Введена неверная скидка продукта " + productName + " Введенная скидка " + discount);
        }
        this.discount = discount;


    }

    @Override
    public double getProductCost() {
        return basicCoast * (1 - discount / 100.0);
    }

    @Override
    public String toString() {
        return getproductName() + " со скидкой: " + getProductCost() + " (" + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        DiscountedProduct that = (DiscountedProduct) object;
        return basicCoast == that.basicCoast && discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), basicCoast, discount);
    }
}
