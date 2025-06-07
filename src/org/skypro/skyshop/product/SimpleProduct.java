package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int productCoast;

    public SimpleProduct(String productName, int productCoast) {
        super(productName);
        try {
            if (productCoast < 1) {
                throw new IllegalArgumentException();
            } else {
                this.productCoast = productCoast;
            }

        } catch (Exception e) {
            System.out.println("Введена неверная цена продукта " + productName);
            ;
        } finally {
            System.out.println("Проверка успешна");
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
