package org.skypro.skyshop.SearchEngine;

import org.skypro.skyshop.Exception.BestResultNotFound;

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
            if (searchables[i] != null && searchables[i].searchTerm() != null && searchables[i].searchTerm().contains(term)) {
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

    public Searchable[] bestResultsSearch(String term) {
        Searchable[] bestResults = new Searchable[5];
        int indexOfFinded = 0;
        int tempCount = 0;
        int countOfFinded = 0;
        try {
            for (int i = 0; i < searchables.length; i++) {
                if (searchables[i] != null && searchables[i].searchTerm() != null && searchables[i].searchTerm().contains(term)) {
                    tempCount = resultsOfCoincidence(term, searchables[i]);
                    if (tempCount == countOfFinded) {
                        for (int j = 0; j < bestResults.length; j++) {
                            if (bestResults[indexOfFinded] != null) {
                                indexOfFinded++;
                                break;
                            }
                        }
                        bestResults[indexOfFinded] = searchables[i];
                    }
                    if (tempCount > countOfFinded) {
                        countOfFinded = tempCount;
                        indexOfFinded = 0;
                        for (int j = 0; j < bestResults.length - indexOfFinded; j++) {
                            bestResults[j + indexOfFinded] = null;
                        }
                        bestResults[indexOfFinded] = searchables[i];
                    }
                }
            }
            if (indexOfFinded == 0) {
                throw new BestResultNotFound();
            }
        } catch (BestResultNotFound e) {
            System.out.println("Похожие элементы для запроса " + term + " не найдены");
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
