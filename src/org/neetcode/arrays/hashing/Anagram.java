package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Anagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i = 0; i < s.length(); i++) {
            a[((int) s.charAt(i))-97]++;
        }
        for(int i = 0; i < t.length(); i++) {
            b[((int) t.charAt(i))-97]++;
        }
        for(int i = 0; i< 26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagara";
        System.out.println(isAnagram(s,t));
    }
}
