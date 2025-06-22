package org.skypro.skyshop.SearchEngine;

import java.util.Comparator;

public interface Searchable {

    String searchTerm();

    String getContentType();

    String getproductName();

    default String getStringRepresentation() {
        return searchTerm() + " " + getContentType();
    }

    public class SearchableComparable implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            if (s1 == null && s2 == null) return 0;
            if (s1 == null) return -1;
            if (s2 == null) return 1;
            int lengthComparison = Integer.compare(s2.getproductName().length(), s1.getproductName().length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return s1.getproductName().compareTo(s2.getproductName());
        }
    }
}
