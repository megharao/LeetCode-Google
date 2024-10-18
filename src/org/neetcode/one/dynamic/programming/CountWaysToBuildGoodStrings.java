package org.neetcode.one.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class CountWaysToBuildGoodStrings {
    Map<Integer, Integer> dp;
    int mod = 1000000007;
    public int countGoodStrings(int low, int high, int zero, int one) {
        dp = new HashMap<>(); //length -> num of strings
        dp.put(0,1);
        for(int i = 1; i <= high; i++) {
            int value = (dp.getOrDefault(i-one,0) + dp.getOrDefault(i-zero,0)) % mod;
            dp.put(i,value);
        }
        return dp.entrySet().stream().filter(entry -> (entry.getKey() >= low && entry.getKey() <= high)).map(entry -> entry.getValue()).reduce(Integer::sum).get() % mod;
//        return dfs(0,high,low,zero,one);
    }

    public int dfs(int length, int high, int low, int zero, int one) {
        if(length > high) {
            return 0;
        }
        if(dp.containsKey(length)) {
            return dp.get(length);
        }
        dp.put(length,length >= low ? 1 : 0);
        dp.put(length, dp.get(length) + dfs(length+zero, high,low,zero,one) + dfs(length+one, high,low,zero,one));
        return dp.get(length)%mod;
    }
}
