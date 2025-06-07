package org.skypro.skyshop.product;

import org.skypro.skyshop.Exception.BestResultNotFound;
import org.skypro.skyshop.SearchEngine.Searchable;

public abstract class Product implements Searchable {
    private String productName;


    public Product(String productName) {
        try {
            if (productName == null) {
                throw new IllegalArgumentException();
            } else {
                this.productName = productName;
            }
            if (productName.isBlank()) {
                throw new BestResultNotFound();
            } else {
                this.productName = productName;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Имя не введено");
        } catch (Exception e) {
            System.out.println("Имя состоит из одних пробелов");
        } finally {
            System.out.println("Проверка успешна");
        }
    }


    public abstract double getProductCoast();

    public String getproductName() {
        return productName;
    }

    public abstract String toString();


    public boolean isSpecial() {
        return false;
    }

    public String setproductName() {
        return productName;
    }

    @Override
    public boolean equals(Object obj) {

        Product product = (Product) obj;
        return productName.equals(product.productName);
    }

    @Override
    public String searchTerm() {
        return productName;
    }

    public String getContentType() {
        return "PRODUCT";
    }
}



