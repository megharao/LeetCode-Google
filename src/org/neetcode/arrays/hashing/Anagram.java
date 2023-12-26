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
        int[] sInt = new int[26];
        int[] tInt = new int[26];
        for(char c: s.toCharArray()) {
            sInt[c-'a']++;
        }
        for(char c: t.toCharArray()) {
            sInt[c-'a']++;
        }

        for(int i = 0; i < 26; i++) {
            System.out.println(sInt[i] + " " + tInt[i]);
            if(sInt[i] != tInt[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s,t));
    }
}
