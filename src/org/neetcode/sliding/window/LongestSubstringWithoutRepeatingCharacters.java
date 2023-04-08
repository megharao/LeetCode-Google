package org.neetcode.sliding.window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        Set<String> chars = new HashSet<>();
        for(int right = 0; right < s.length(); right++) {
            String r = String.valueOf(s.charAt(right));
            String l = String.valueOf(s.charAt(left));
            while(chars.contains(r)){
                chars.remove(l);
                left++;
                l = String.valueOf(s.charAt(left));
            }
            chars.add(r);
            maxLen = Math.max(maxLen, right - left +1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
