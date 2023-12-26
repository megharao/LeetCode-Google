package org.neetcode.arrays.hashing;

import java.util.*;

public class SubSeqPali {
    public int countPalindromicSubsequence(String s) {
        Set<String> pali = new HashSet<>(); //middle,outer at most 26^2 pali
        Set<String> left = new HashSet<>();
        Map<String, Integer> right = new HashMap<>();
        s.chars().forEach(c -> {
            right.put(Character.toString(c), right.getOrDefault(Character.toString(c), 0) + 1);
        });
        for(int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            right.put(c,right.get(c)-1);
            if(right.get(c) == 0) {
                right.remove(c);
            }
            for(int j = 0; j < 26; j++) {
                String ch = Character.toString('a'+j);
                if(left.contains(ch) && right.containsKey(ch)) {
                    pali.add(c+ch);
                }
            }
            left.add(c);
        }
        return pali.size();
    }

    public static void main(String[] args) {
        SubSeqPali subSeqPali = new SubSeqPali();
        System.out.println(subSeqPali.countPalindromicSubsequence("bbcbaba"));
    }
}
