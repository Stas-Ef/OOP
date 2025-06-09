package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exception.BestResultNotFound;


import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;


    public SearchEngine() {
        this.searchables = new LinkedList<>();
    }

    public List<Searchable> search(String term) {
        List<Searchable> results = new LinkedList<>();
        for (Searchable search : searchables) {
            if (search != null && search.searchTerm() != null && search.searchTerm().contains(term)) {
                results.add(search);
            }
        }
        return results;
    }

    public void add(Searchable term) {
        if (term == null) {
            throw new IllegalArgumentException("Продукт не может быть пустым");
        }
        searchables.add(term);

    }

    @Override
    public String toString() {
        return searchables.toString();
    }

    public List<Searchable> bestResultsSearch(String term) throws BestResultNotFound {
        List<Searchable> bestResults = new LinkedList<>();
        int tempCount = 0;
        int countOfFinded = 0;

        for (Searchable bestResult : searchables) {
            if (bestResult != null && bestResult.searchTerm() != null && bestResult.searchTerm().contains(term)) {
                tempCount = resultsOfCoincidence(term, bestResult);
                if (tempCount == countOfFinded && bestResult != null) {
                    bestResults.add(bestResult);
                }
                if (tempCount > countOfFinded) {
                    countOfFinded = tempCount;
                    bestResults.clear();
                    bestResults.add(bestResult);
                }
            }
        }
        if (bestResults.isEmpty()) {
            throw new BestResultNotFound("Похожие элементы для запроса  не найдены");
        }
        return bestResults;
    }

    public int resultsOfCoincidence(String term, Searchable product) {
        int resultCount = 0;
        int index = 0;
        if (product != null) {
            int indexString = product.searchTerm().toLowerCase().indexOf(term.toLowerCase(), index);
            while (indexString != -1) {
                resultCount++;
                index = indexString + term.length();
                indexString = product.searchTerm().toLowerCase().indexOf(term.toLowerCase(), index);
            }
        } else {
            resultCount = 0;
        }
        return resultCount;
    }
}
