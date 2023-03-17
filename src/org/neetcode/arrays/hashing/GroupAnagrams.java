package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs.length == 0) {
            return res;
        }
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] hash = new char[26];
            for(char c: s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(hash);
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        res.addAll(map.values());
        return res;
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
