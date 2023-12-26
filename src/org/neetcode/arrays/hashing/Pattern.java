package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class Pattern {
    public boolean wordPattern(String pattern, String s) {
        Map<String,String> charToWord = new HashMap<>();
        Map<String, String> wordToChar = new HashMap<>();
        String[] sArr = s.split(" ");
        if(sArr.length != pattern.length()) {
            return false;
        }
        for(int i = 0; i < pattern.length(); i++) {
            String c = String.valueOf(pattern.charAt(i));
            if(!charToWord.containsKey(c)) {
                charToWord.put(c,sArr[i]);
            }
            if(!wordToChar.containsKey(sArr[i])) {
                wordToChar.put(sArr[i],c);
            }
            if (!charToWord.get(c).equals(sArr[i]) || !wordToChar.get(sArr[i]).equals(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "aaaa", s = "dog cat cat dog";
        Pattern p = new Pattern();
        System.out.println(p.wordPattern(pattern,s));
    }
}
