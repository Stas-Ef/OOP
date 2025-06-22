package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exception.BestResultNotFound;
import org.skypro.skyshop.product.Product;


import java.util.*;

public class SearchEngine {
    private Map<String, Set<Searchable>> searchables;


    public SearchEngine() {
        this.searchables = new HashMap<>();
    }

    public void add(Searchable term) {
        if (term == null) {
            throw new IllegalArgumentException("Продукт для поиска не может быть пустым");
        }
        Set<Searchable> findList = searchables.getOrDefault(term.searchTerm(), new HashSet<>());
        findList.add(term);
        searchables.put(term.getproductName(), findList);

    }

    @Override
    public String toString() {
        return searchables.toString();
    }

    public Set<String> search(String term) {
        Set<String> results = new TreeSet<>(stringComparator);
        for (Set<Searchable> findTerm : searchables.values()) {
            for (Searchable search : findTerm) {
                if (search != null && search.searchTerm() != null && search.searchTerm().contains(term)) {
                    results.add(search.getproductName());
                }
            }
        }
        return results;
    }

    public Set<Searchable> bestResultsSearch(String term) throws BestResultNotFound {
        Set<Searchable> bestResults = new TreeSet<>(new Searchable.SearchableComparable());
        int countOfFinded = 0;
        for (Set<Searchable> findTerm : searchables.values()) {
            for (Searchable bestResult : findTerm) {
                if (bestResult != null && bestResult.searchTerm() != null && bestResult.searchTerm().contains(term)) {
                    int tempCount = resultsOfCoincidence(term, bestResult);
                    if (tempCount > countOfFinded) {
                        countOfFinded = tempCount;
                        bestResults.clear();
                        bestResults.add(bestResult);
                    } else if (tempCount == countOfFinded) {
                        bestResults.add(bestResult);
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

    Comparator<String> stringComparator = new Comparator<>() {
        @Override
        public int compare(String s1, String s2) {
            int lengthComparison = Integer.compare(s2.length(), s1.length()); // от большего к меньшему
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return s1.compareTo(s2); // при равной длине — по алфавиту
        }
    };
}
