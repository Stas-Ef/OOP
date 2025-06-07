package org.skypro.skyshop.SearchEngine;

public interface Searchable {

    String searchTerm();

    String getContentType();

    default String getStringRepresentation() {
        return searchTerm() + " " + getContentType();
    }

}
