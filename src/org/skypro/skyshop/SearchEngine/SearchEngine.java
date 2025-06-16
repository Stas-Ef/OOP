package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exception.BestResultNotFound;
import org.skypro.skyshop.product.Product;


import java.util.*;

public class SearchEngine {
    private Map<String, List<Searchable>> searchables;


    public SearchEngine() {
        this.searchables = new TreeMap<>();
    }

    public void add(Searchable term) {
        if (term == null) {
            throw new IllegalArgumentException("Продукт для поиска не может быть пустым");
        }
        List<Searchable> findList = searchables.getOrDefault(term.searchTerm(), new ArrayList<>());
        findList.add(term);
        searchables.put(term.getproductName(), findList);

    }

    @Override
    public String toString() {
        return searchables.toString();
    }

    public Map<String, Searchable> search(String term) {
        Map<String, Searchable> results = new TreeMap<>();
        for (List<Searchable> findTerm : searchables.values()) {
            for (Searchable search : findTerm) {
                if (search != null && search.searchTerm() != null && search.searchTerm().contains(term)) {
                    results.put(search.getproductName(), search);
                }
            }
        }
        return results;
    }

    public Map<String, Searchable> bestResultsSearch(String term) throws BestResultNotFound {
        Map<String, Searchable> bestResults = new TreeMap<>();
        int countOfFinded = 0;
        for (List<Searchable> findTerm : searchables.values()) {
            for (Searchable bestResult : findTerm) {
                if (bestResult != null && bestResult.searchTerm() != null && bestResult.searchTerm().contains(term)) {
                    int tempCount = resultsOfCoincidence(term, bestResult);
                    if (tempCount > countOfFinded) {
                        countOfFinded = tempCount;
                        bestResults.clear();
                        bestResults.put(bestResult.getproductName(), bestResult);
                    } else if (tempCount == countOfFinded) {
                        bestResults.putIfAbsent(bestResult.getproductName(), bestResult);
                    }
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
        }
        return resultCount;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        SearchEngine that = (SearchEngine) object;
        return Objects.equals(searchables, that.searchables);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(searchables);
    }
}
