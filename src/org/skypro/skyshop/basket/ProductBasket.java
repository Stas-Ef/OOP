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
        return basket.values().stream()
                .flatMap(Collection::stream)
                .mapToDouble(Product::getProductCost)
                .sum();
    }


    public void printBasket() {
        System.out.println("Печать корзины:");
        if (basket == null || basket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }


        basket.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> {
                    if (product != null) {
                        System.out.println(product);
                    }
                });

        long specialCount = getSpecialCount();

        System.out.println("___________________________");
        System.out.println("Итого: " + costOfBasket());
        System.out.println("Специальных товаров: " + specialCount);
    }


    private long getSpecialCount() {
        return basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }


    public boolean findProductBasket(Product productToFind) {
        if (productToFind == null || productToFind.getproductName() == null) {
            return false;
        }
        return basket.values().stream()
                .flatMap(Collection::stream)
                .anyMatch(product ->
                        product != null &&
                                product.getproductName() != null &&
                                product.getproductName().equals(productToFind.getproductName())
                );
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

