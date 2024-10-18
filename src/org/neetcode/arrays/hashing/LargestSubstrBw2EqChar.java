package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class LargestSubstrBw2EqChar {
    public static int maxLengthBetweenEqualCharacters(String s) {
        Map<String, Integer> indexMap = new HashMap<>();
        int res = -1;
        for(int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            if(indexMap.containsKey(c)) {
                res = Math.max(res, i-indexMap.get(c)-1);
            } else {
                indexMap.put(c,i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbzxy";
        System.out.println(maxLengthBetweenEqualCharacters(s));
    }
}
