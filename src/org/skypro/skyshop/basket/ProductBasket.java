package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    Product[] basket = new Product[5];

    public void ProductBasket() {
    }


    public void AddProductBasket(Product productName) {
        boolean isFull = true;
        for (int i = 0; i < basket.length; i++) {

            if (basket[i] == null) {
                basket[i] = productName;
                System.out.println("Добавлен = " + basket[i].getproductName() + " " + basket[i].getProductCoast());
                isFull = false;
                break;
            }
        }
        if (isFull) {

            System.out.println("Невозможно добавить продукт");
        }
    }

    public int coastOfBasket() {
        int summ = 0;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                summ = basket[i].getProductCoast() + summ;
            }
        }
        return summ;
    }

    public void printBasket() {
        boolean isEmpty = true;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                isEmpty = false;
                System.out.println(basket[i].getproductName() + ": " + basket[i].getProductCoast());
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто");

        } else {
            System.out.println("Итого: " + coastOfBasket());
        }
    }


    public boolean findProductBasket(Product productName) {
        boolean isFind = false;
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] != null) {
                if (basket[i].getproductName().equals(productName.getproductName())) {
                    isFind = true;
                    break;
                }
            }
        }

        return isFind;
    }

    public void clearBasket() {
        for (int i = 0; i < basket.length; i++) {
            basket[i] = null;
        }
    }
}

