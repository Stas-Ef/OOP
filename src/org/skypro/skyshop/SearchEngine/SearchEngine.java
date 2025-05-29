package org.skypro.skyshop.SearchEngine;

import java.util.Arrays;

public class SearchEngine {
    private Searchable[] searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new Searchable[size];

    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;

        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] != null && searchables[i].searchTerm().contains(term)) {
                if (resultCount < 5) {
                    results[resultCount++] = searchables[i];
                } else {
                    break;
                }
            }
        }
               return results;
    }

    public void add(Searchable term) {
        if (count < searchables.length) {
            searchables[count] = term;
            count++;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(searchables);
    }

}
