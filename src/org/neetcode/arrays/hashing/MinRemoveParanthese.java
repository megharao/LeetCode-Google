package org.neetcode.arrays.hashing;

import java.util.*;
import java.util.stream.Collectors;

public class MinRemoveParanthese {
    public static String minRemoveToMakeValid(String s) {
        List<Character> res = new ArrayList<>();
        int count = 0;
        for(char c: s.toCharArray()) {
            if(c == '(') {
                res.add(c);
                count++;
            }
            else if(c == ')' && count > 0) {
                res.add(c);
                count--;
            } else if (c != ')') {
                res.add(c);
            }
        }
        List<Character> filtered = new ArrayList<>();
        for(int i = res.size()-1; i >= 0; i--) {
            if(res.get(i) == '(' && count > 0) {
                count--;
            } else {
                filtered.add(res.get(i));
            }
        }
        Collections.reverse(filtered);
        return filtered.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String s = "lee(t(c)o)de)";
        System.out.println(minRemoveToMakeValid(s));
    }
}
