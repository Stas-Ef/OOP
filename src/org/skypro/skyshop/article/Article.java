package org.skypro.skyshop.article;

import org.skypro.skyshop.SearchEngine.Searchable;

import java.util.Objects;

final public class Article implements Searchable {
    String name;
    String text;


    public Article(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getproductName() {
        return name;
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

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Article article)) return false;
        return Objects.equals(name, article.name) && Objects.equals(text, article.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, text);
    }
}
