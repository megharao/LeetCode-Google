package org.neetcode.arrays.hashing;

import java.util.Arrays;
import java.util.Comparator;

public class LongComPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        int i = 0;
        int minLen = Arrays.stream(strs).map(s -> s.length()).min(Comparator.comparingInt(Integer::intValue)).get();
        while(i < minLen) {
            char prev = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(prev == strs[j].charAt(i)) {
                    continue;
                } else {
                    return prefix;
                }
            }
            prefix += prev;
            i++;
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        LongComPrefix longComPrefix = new LongComPrefix();
        System.out.println(longComPrefix.longestCommonPrefix(strs));
    }
}
