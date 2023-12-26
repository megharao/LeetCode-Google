package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(i+p.length() <= s.length() && isAnagram(s.substring(i,i+p.length()),p)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sInt = new int[26];
        int[] tInt = new int[26];
        for(char c: s.toCharArray()) {
            sInt[c-'a']++;
        }
        for(char c: t.toCharArray()) {
            tInt[c-'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(sInt[i] != tInt[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams(s,p));
    }
}
