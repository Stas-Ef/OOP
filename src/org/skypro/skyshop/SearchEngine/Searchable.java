package org.skypro.skyshop.SearchEngine;


public interface Searchable {

    String searchTerm();

    String getContentType();

    String getproductName();


    default String getStringRepresentation() {
        return searchTerm() + " " + getContentType();
    }
}
