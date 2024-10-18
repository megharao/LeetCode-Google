package org.neetcode.arrays.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class SortByCharFreq {
    public static String frequencySort(String s) {
        int[] freq = new int[128];
        for(char c: s.toCharArray()) {
            freq[c]++;
        }
        char[] res = new char[s.length()];
        int index = 0;
        while(index < s.length()) {
            int maxf = 0;
            char maxc = 0;
            for(int i = 0; i < freq.length; i++) {
                if(freq[i] > maxf) {
                    maxf = freq[i];
                    maxc = (char) i;
                }
            }
            for(int i = 0; i < maxf; i++) {
                res[index++] = maxc;
            }
            freq[maxc] = 0;
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String s = "eert";
        System.out.println(frequencySort(s));
    }
}
