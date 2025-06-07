package org.skypro.skyshop.product;

import org.skypro.skyshop.Exception.DiscountPriceException;

public class DiscountedProduct extends Product {
    private int basicCoast;
    private int discount;

    public DiscountedProduct(String productName, int basicCoast, int discount) {
        super(productName);
        try {
            if (basicCoast < 1) {
                throw new IllegalArgumentException();
            } else {
                this.basicCoast = basicCoast;
            }
            if (discount < 0 || discount > 100) {
                throw new DiscountPriceException();
            } else {
                this.discount = discount;
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Введена неверная цена продукта " + basicCoast);
        } catch (DiscountPriceException e) {
            System.out.println("Введена неверная скидка продукта " + discount);

        } finally {
            System.out.println("Проверка успешна");
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
