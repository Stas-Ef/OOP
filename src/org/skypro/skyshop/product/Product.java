package org.skypro.skyshop.product;

public abstract class Product {
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
}



