package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {

        Product Apple = new Product("Яблоки", 1);

        Product Banana = new Product("Бананы", 10);
        Product Onion = new Product("Лук", 100);
        Product Pineapple = new Product("Ананас", 100000);
        Product Watermelon = new Product("Арбуз", 1000);
        Product Potato = new Product("Картофель", 10000);
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
    }
}