package org.skypro.skyshop.product;

import org.skypro.skyshop.SearchEngine.Searchable;

public abstract class Product implements Searchable {
    private String productName;


    public Product(String productName) {
        this.productName = productName;

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



