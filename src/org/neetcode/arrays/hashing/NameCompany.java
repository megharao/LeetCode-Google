package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NameCompany {
    public long distinctNames(String[] ideas) {
        Map<String, Set<String>> map = new HashMap<>();
        long res = 0;
        for(String w : ideas) {
            Set<String> words = map.getOrDefault(String.valueOf(w.charAt(0)),new HashSet<>());
            words.add(w.substring(1));
            map.put(String.valueOf(w.charAt(0)),words);
        }
        for(Map.Entry<String, Set<String>> entry1 : map.entrySet()) {
            for(Map.Entry<String, Set<String>> entry2 : map.entrySet()) {
                if(entry1.getKey().equals(entry2.getKey())) {
                    continue;
                }
                int duplicate = 0;
                for(String word: map.get(entry1.getKey())) {
                    if(map.get(entry2.getKey()).contains(word)) {
                        duplicate++;
                    }
                }
                int distinct1 = map.get(entry1.getKey()).size() - duplicate;
                int distinct2 = map.get(entry2.getKey()).size() - duplicate;
                res += distinct1 * distinct2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] ideas = {"coffee","donuts","time","toffee"};
        NameCompany nameCompany = new NameCompany();
        System.out.println(nameCompany.distinctNames(ideas));
    }
}
