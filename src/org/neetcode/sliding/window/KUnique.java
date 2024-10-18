package org.neetcode.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KUnique {
    public static String KUniqueCharacters(String str) {
        // code goes here
        int k =  Integer.valueOf(String.valueOf(str.charAt(0)));
        str = str.substring(1);
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int currentWindowLength = 0;
        int startWindow = 0;
        int maxLength = 1;
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            charIndexMap.put(currentChar, i);

            if (charIndexMap.size() > k) {
                int minIndex = Integer.MAX_VALUE;
                for (int index : charIndexMap.values()) {
                    minIndex = Math.min(minIndex, index);
                }
                charIndexMap.remove(str.charAt(minIndex));
                startWindow = minIndex + 1;
            }

            currentWindowLength = i - startWindow + 1;
            if(currentWindowLength > maxLength) {
                maxLength = currentWindowLength;
                res = str.substring(startWindow,i+1);
            }

        }

        return res;
    }

    public static void main(String[] args) {
        String s= "3aabacbebebe";
        System.out.println(KUnique.KUniqueCharacters(s));
    }
}
