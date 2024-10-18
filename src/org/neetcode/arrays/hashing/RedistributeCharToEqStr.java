package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharToEqStr {

    public static boolean makeEqual(String[] words) {
        boolean res = true;
        Map<String, Integer> countMap = new HashMap<>();
        for(String word: words) {
            for(char c: word.toCharArray()) {
                countMap.put(String.valueOf(c), countMap.getOrDefault(String.valueOf(c), 0) + 1);
            }
        }
        int numOfWords = words.length;
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() % numOfWords != 0) {
                return false;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String[] words = {"ab","a"};
        System.out.println(makeEqual(words));
    }
}
