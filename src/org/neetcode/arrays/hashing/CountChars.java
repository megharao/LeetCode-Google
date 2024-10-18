package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class CountChars {
    public int countCharacters(String[] words, String chars) {
        int count = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        for(char c: chars.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c,0)+1);
        }
        for(String w: words) {
            if(isGood(w, charCount)) {
                count += w.length();
            }
        }
        return count;
    }

    public boolean isGood(String word, Map<Character, Integer> charCount) {
        Map<Character, Integer> wordCount = new HashMap<>();
        for(char c: word.toCharArray()) {
            wordCount.put(c, wordCount.getOrDefault(c,0)+1);
        }
        for(Character c : wordCount.keySet()) {
            if(!charCount.containsKey(c)) {
                return false;
            } else {
                if (wordCount.get(c) > charCount.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        CountChars countChars = new CountChars();
        System.out.println(countChars.countCharacters(words,chars));
    }
}
