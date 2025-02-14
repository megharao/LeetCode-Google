package org.neetcode.backtracking;

import java.util.*;

public class NumOfBeautifulSubSets {

    Map<Integer, Integer> cache = new HashMap<>();
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Map<Integer, Integer>> groups = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for(int key: map.keySet()) {
            if(visited.contains(key)) {
                continue;
            }
            Map<Integer, Integer> g = new HashMap<>();
            while (map.containsKey(key-k)) {
                key -= k;
            }
            while (map.containsKey(key)) {
                g.put(key, map.get(k));
                visited.add(key);
                key += k;
            }
            groups.add(g);
        }
        int res = 1;
        for(Map<Integer, Integer> g: groups) {
            int n = g.keySet().stream().min(Comparator.comparing(Integer::intValue)).get();
            res *= dfs(n,g,k);
        }
        return res-1;
    }

    public int dfs(int n, Map<Integer, Integer> g, int k) {
        if(!g.containsKey(n)) {
            return 1;
        }
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        int skip = dfs(n+k, g, k);
        int count = g.getOrDefault(n,0);
        int include = ((int) Math.pow(2,count) - 1) //for duplicate numbers
                * dfs(n +(int) Math.pow(2,k), g, k);
        cache.put(n, skip+include);
        return skip+include;
    }


    public static void main(String[] args) {
        int[] nums = {4,2,5,9,10,3};
        int k = 1;
        NumOfBeautifulSubSets obj = new NumOfBeautifulSubSets();
        System.out.println(obj.beautifulSubsets(nums, k));
    }
}
