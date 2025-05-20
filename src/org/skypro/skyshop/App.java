package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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
    }
}