package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> basket;
    private int size;

    public ProductBasket() {
        this.basket = new HashMap<>();
        size = 0;
    }


    public void addProductToBasket(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть пустым");
        }
        List<Product> productList = basket.getOrDefault(product.getproductName(), new ArrayList<>());
        productList.add(product);
        basket.put(product.getproductName(), productList);
        size++;
        System.out.println("Добавлен продукт: " + product.getproductName());
    }

    public int getSize() {
        return size;
    }

    public double costOfBasket() {
        double summ = 0;
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                summ += product.getProductCost();
            }
        }
        return summ;
    }

    public void printBasket() {
        int amount = 0;
        System.out.println("Печать корзины:");
        if (basket == null || basket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        for (List<Product> products : basket.values()) {
            for (Product product : products) {
                if (product != null) {
                    System.out.println(product);
                    if (product.isSpecial()) {
                        amount++;
                    }
                }
            }
        }
        System.out.println("___________________________");
        System.out.println("Итого: " + costOfBasket());
        System.out.println("Специальных товаров: " + amount);
    }


    public boolean findProductBasket(Product productToFind) {
        if (productToFind == null || productToFind.getproductName() == null) {
            return false;
        }
        List<Product> products = basket.get(productToFind.getproductName());
        if (products != null) {
            for (Product product : products) {
                if (product != null) {
                    if (product.getproductName() != null && product.getproductName().equals(productToFind.getproductName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        basket.clear();
        size = 0;
        System.out.println("Очистка корзины");
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        if (name == null || basket.isEmpty()) {
            return removedProducts;
        }
        List<Product> productsToRemove = basket.get(name);
        if (productsToRemove != null) {
            removedProducts.addAll(productsToRemove);
            basket.remove(name);
            size -= removedProducts.size();
        }

        return removedProducts;
    }
}

