package org.skypro.skyshop;

import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;


import java.util.List;

public class App {
    public static void main(String[] args) {

        try {

            SimpleProduct Apple = new SimpleProduct("Яблоки", 1);

            SimpleProduct Banana = new SimpleProduct("Бананы", 10);
            FixPriceProduct Onion = new FixPriceProduct("Лук");
            DiscountedProduct Pineapple = new DiscountedProduct("Ананас", 100000, 15);
            SimpleProduct Watermelon = new SimpleProduct("Арбуз", 1000);
            SimpleProduct Potato = new SimpleProduct("Картофель", 10000);
            ProductBasket people1 = new ProductBasket();

            people1.addProductToBasket(Banana);
            people1.addProductToBasket(Apple);
            people1.addProductToBasket(Onion);
            people1.addProductToBasket(Pineapple);
            people1.addProductToBasket(Watermelon);
            people1.addProductToBasket(Potato);


            System.out.println("1======================================");
            List<Product> removedProduct = people1.removeProductsByName("Бананы");
            System.out.println("Удален продукт" + removedProduct);
            people1.printBasket();


            List<Product> removedProduct2 = people1.removeProductsByName("Кабачок");
            if (removedProduct2.isEmpty()) {
                System.out.println("Список пуст");
            }
            people1.printBasket();

            System.out.println("2======================================");
            people1.clearBasket();
            people1.addProductToBasket(Onion);

            people1.printBasket();
            System.out.println("3======================================");
            people1.clearBasket();
            people1.printBasket();
            System.out.println("people1.findProductBasket(Banana) = " + people1.findProductBasket(Banana));
            System.out.println("people1.coastOfBasket() = " + people1.costOfBasket());
            System.out.println("4======================================");

            Article miniBananas = new Article("Маленькие Бананы", "Почти как бананы, только в несколько раз меньше. Не Яблоки.");
            Article tomato = new Article("Помидоры", "Красные, но Не Яблоки.");
            Article strawberry = new Article("Ягоды", "совсем не Яблоки.");
            Article antonovka = new Article("Яблоки \"Антоновка\"", "Одна из многих разновидностей яблок");
            Article gala = new Article("Яблоки \"Гала\"", "Еще одна из многих разновидностей яблок");

            SearchEngine SearchOne = new SearchEngine();

            SearchOne.add(miniBananas);
            SearchOne.add(Banana);
            SearchOne.add(Apple);
            SearchOne.add(Onion);
            SearchOne.add(Pineapple);
            SearchOne.add(Watermelon);
            SearchOne.add(Potato);
            SearchOne.add(antonovka);
            SearchOne.add(gala);
            SearchOne.add(tomato);
            SearchOne.add(strawberry);
            System.out.println("печать SearchOne " + SearchOne);
            System.out.println("Печать найенного " + SearchOne.search("Ябло").toString());


            System.out.println("5======================================");
            System.out.println("Печать лучшего найденного " + SearchOne.bestResultsSearch("Ябло").toString());
            System.out.println("Печать лучшего найденного " + SearchOne.bestResultsSearch("Космос").toString());

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("Проверка выполнена");
        }
    }
}
