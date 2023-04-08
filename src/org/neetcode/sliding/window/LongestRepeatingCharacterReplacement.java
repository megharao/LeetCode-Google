package org.neetcode.sliding.window;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        Map<String, Integer> charCount = new HashMap<>();
        int l = 0;
        int res = 0;
        for(int r = 0; r < s.length(); r++) {
            String right = String.valueOf(s.charAt(r));
            charCount.merge(right, 1, Integer::sum);
            int maxRepeatedCount = Collections.max(charCount.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
            if(r-l+1 - maxRepeatedCount > k) {
                String left = String.valueOf(s.charAt(l));
                int count = charCount.get(left);
                count--;
                charCount.put(left, count);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "ABBA";
        System.out.println(characterReplacement(s,2));
    }
}
