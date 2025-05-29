package org.skypro.skyshop;

import org.skypro.skyshop.SearchEngine.SearchEngine;
import org.skypro.skyshop.SearchEngine.Searchable;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        SimpleProduct Apple = new SimpleProduct("Яблоки", 1);

        SimpleProduct Banana = new SimpleProduct("Бананы", 10);
        FixPriceProduct Onion = new FixPriceProduct("Лук");
        DiscountedProduct Pineapple = new DiscountedProduct("Ананас", 100000, 15);
        SimpleProduct Watermelon = new SimpleProduct("Арбуз", 1000);
        SimpleProduct Potato = new SimpleProduct("Картофель", 10000);
        ProductBasket people1 = new ProductBasket();
        System.out.println("======================================");
        people1.AddProductBasket(Banana);
        people1.AddProductBasket(Apple);
        people1.AddProductBasket(Onion);
        people1.AddProductBasket(Pineapple);
        people1.AddProductBasket(Watermelon);
        people1.AddProductBasket(Potato);
        System.out.println("=====sss=============================");
        System.out.println("people1.findProductBasket(Banana) = " + people1.findProductBasket(Banana));
        System.out.println("people1.findProductBasket(Potato) = " + people1.findProductBasket(Potato));
        System.out.println("======================================");

        people1.printBasket();
        System.out.println("======================================");
        people1.clearBasket();
        people1.AddProductBasket(Onion);

        people1.printBasket();
        System.out.println("======================================");
        people1.clearBasket();
        people1.printBasket();
        System.out.println("people1.findProductBasket(Banana) = " + people1.findProductBasket(Banana));
        System.out.println("people1.coastOfBasket() = " + people1.coastOfBasket());
        System.out.println("======================================");

        Article miniBananas = new Article("Маленькие Бананы", "Почти как бананы, только в несколько раз меньше. Не Яблоки.");
        Article tomato = new Article("Помидоры", "Красные, но Не Яблоки.");
        Article strawberry = new Article("Ягоды", "совсем не Яблоки.");
        Article antonovka = new Article("Яблоки \"Антоновка\"", "Одна из многих разновидностей яблок");
        Article gala = new Article("Яблоки \"Гала\"", "Еще одна из многих разновидностей яблок");

        SearchEngine SearchOne = new SearchEngine(15);

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

        System.out.println("печать массива SearchOne " + SearchOne.toString());



        System.out.println("Печать найенного " + Arrays.toString(SearchOne.search("Ябло")));
        //SearchOne.search("Банан");
    }
}