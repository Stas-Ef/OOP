package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> basket;
    private int size;

    public ProductBasket() {
        this.basket = new LinkedList<>();
        size = 0;
    }


    public void addProductToBasket(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть пустым");
        }
        basket.add(product);
        size++;
        System.out.println("Добавлен продукт: " + product.getproductName());
    }

    public int getSize() {
        return size;
    }

    public double costOfBasket() {
        double summ = 0;
        for (Product product : basket) {
            summ += product.getProductCoast();
        }
        return summ;
    }

    public void printBasket() {
        int amount = 0;
        System.out.println("Печать корзины:");
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product.toString());
            }
            if (product != null && product.isSpecial()) {
                amount++;
            }
        }
        if (basket == null || basket.isEmpty()) {
            System.out.println("В корзине пусто");

        } else {
            System.out.println("___________________________");
            System.out.println("Итого: " + costOfBasket());
            System.out.println("Специальных товаров: " + amount);

        }

    }


    public boolean findProductBasket(Product productToFind) {
        for (Product product : basket) {
            if (product != null) {
                if (product.getproductName() != null && product.getproductName().equals(productToFind.getproductName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
        System.out.println("Очистка корзины");
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        if (name == null || basket == null) {
            return removedProducts;
        }
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product != null && product.getproductName() != null && product.getproductName().equals(name)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }
        return removedProducts;
    }
}

