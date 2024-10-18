package org.neetcode.binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SearchSuggestions {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        int l =0, r = products.length-1;
        for(int i = 0; i < searchWord.length(); i++) {
            char c = searchWord.charAt(i);
            while (l <= r && (products[l].length() <= i || products[l].charAt(i) != c)) {
                l++;
            }
            while (l <= r && (products[r].length() <= i || products[r].charAt(i) != c)) {
                r--;
            }
            List<String> list = new ArrayList<>();
            int remain = r-l+1;
            for(int j = 0; j < Math.min(3,remain); j++) {
                list.add(products[l+j]);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        SearchSuggestions searchSuggestions = new SearchSuggestions();

    }
}
