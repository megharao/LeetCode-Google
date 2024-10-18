package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharInStr {
    public static int firstUniqChar(String s) {
        Map<String, Integer> countMap = new HashMap<>();
        for(char c: s.toCharArray()) {
            String ch = String.valueOf(c);
            countMap.put(ch, countMap.getOrDefault(ch, 0)+1);
        }
        for(int i = 0; i < s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));
            if(countMap.get(ch) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
