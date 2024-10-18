package org.neetcode.backtracking;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MaxLenOfConcatStrWithUniqueChar {
    Set<Character> charSet = new HashSet<>();
    public int maxLength(List<String> arr) {
        return backtrack(0,arr);
    }

    public int backtrack(int i, List<String> arr) {
        if(i==arr.size()) {
            return charSet.size();
        }
        int res = 0;
        if(!overlap(arr.get(i))) {
            for(char c: arr.get(i).toCharArray()) {
                charSet.add(c);
            }
            res = backtrack(i+1,arr);
            for(char c:arr.get(i).toCharArray()) {
                charSet.remove(c);
            }
        }
        return Math.max(res,backtrack(i+1,arr));
    }

    public boolean overlap(String s) {
        Set<Character> prev = new HashSet<>();
        for(char c : s.toCharArray()) {
            if(charSet.contains(c) ||  prev.contains(c)) {
                return true;
            }
            prev.add(c);
        }
        return false;
    }
}
