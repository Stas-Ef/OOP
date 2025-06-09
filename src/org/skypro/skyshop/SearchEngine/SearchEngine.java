package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exception.BestResultNotFound;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables;
    private int count = 0;

    public SearchEngine(int size) {
        this.searchables = new LinkedList<>();
    }

    public List<Searchable> search(String term) {
        List<Searchable> results = new LinkedList<>();
        int resultCount = 0;

        for (Searchable search : searchables) {
            if (searchables != null && search.searchTerm() != null && search.searchTerm().contains(term) && resultCount < 5) {
                results.add(search);
            } else {
                break;
            }
        }
        return results;
    }

    public void add(Searchable term) {
        if (term == null) {
            throw new IllegalArgumentException("Продукт не может быть пустым");
        }
        searchables.add(term);
        count++;
    }

    @Override
    public String toString() {
        return searchables.toString();
    }

    public List<Searchable> bestResultsSearch(String term) throws BestResultNotFound {
        List<Searchable> bestResults = new LinkedList<>();
        int indexOfFinded = 0;
        int tempCount = 0;
        int countOfFinded = 0;

        for (Searchable bestResult : searchables) {
            if (searchables != null && bestResult.searchTerm() != null && bestResult.searchTerm().contains(term)) {
                tempCount = resultsOfCoincidence(term, bestResult);
                if (tempCount == countOfFinded && bestResult != null) {
                    indexOfFinded++;
                    bestResults.add(bestResult);
                }
                if (tempCount > countOfFinded) {
                    countOfFinded = tempCount;
                    indexOfFinded = 0;
                    for (int j = 0; j < bestResults.size() - indexOfFinded; j++) {
                        bestResult = null;
                    }
                    bestResults.add(bestResult);
                }
            }
        }
        if (indexOfFinded == 0) {
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
