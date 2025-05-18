package org.skypro.skyshop.product;

public class Product {
    private String productName;
    private int productCoast;


    public Product(String productName, int productCoast) {
        this.productName = productName;
        this.productCoast = productCoast;
    }

    public String getproductName() {
        return productName;
    }

    public int getProductCoast() {
        return productCoast;
    }

    public String setproductName() {
        return productName;
    }

    public int setProductCoast() {
        return productCoast;
    }
    @Override
    public boolean equals(Object obj) {

        Product product = (Product) obj;
        return productName.equals(product.productName) && productCoast == (product.productCoast) ;
    }
}