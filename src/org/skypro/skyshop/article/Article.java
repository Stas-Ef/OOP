package org.skypro.skyshop.article;

import org.skypro.skyshop.SearchEngine.Searchable;

final public class Article implements Searchable {
    String name;
    String text;


    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    @Override
    public String toString() {
        return name + " " + '\'' +
                text + '\'';
    }

    public String searchTerm() {
        return toString();
    }

    public String getContentType() {
        return "ARTICLE";
    }
}
