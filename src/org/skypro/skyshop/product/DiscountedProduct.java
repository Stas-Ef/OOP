package org.skypro.skyshop.product;

import org.skypro.skyshop.Exception.DiscountPriceException;
import org.skypro.skyshop.Exception.NameIsBlankException;

import javax.naming.NameAlreadyBoundException;

public class DiscountedProduct extends Product {
    private int basicCoast;
    private int discount;

    public DiscountedProduct(String productName, int basicCoast, int discount) throws DiscountPriceException, IllegalArgumentException, NameIsBlankException {
        super(productName);

        if (basicCoast < 1) {
            throw new IllegalArgumentException("Введена неверная цена продукта " + productName + " Введенная цена: " + basicCoast);
        } else {
            this.basicCoast = basicCoast;
        }
        if (discount < 0 || discount > 100) {
            throw new DiscountPriceException("Введена неверная скидка продукта " + productName + " Введенная скидка " + discount);
        } else {
            this.discount = discount;
        }

    }

    @Override
    public double getProductCoast() {
        return basicCoast * (1 - discount / 100.0);
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
