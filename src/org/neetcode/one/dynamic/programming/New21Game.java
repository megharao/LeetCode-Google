package org.neetcode.one.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class New21Game {
    Map<Integer, Double> dp;
    public double new21Game(int n, int k, int maxPts) {
        dp = new HashMap<>();
        if(k == 1 || k+maxPts <= n) {
            return 1.0;
        }
        double winSum = 0;
        for(int i = k; i <= n; i++) {
            winSum += i <= n ? 1:0;
        }
        for(int i = k-1; i >= 0; i--) {
            dp.put(i, winSum/maxPts);
            double remove = 0;
            if(i+maxPts < k) {
                remove = dp.get(i+maxPts);
            } else if(i+maxPts <= n) {
                remove = 1;
            }
            winSum += dp.get(i) - remove;
        }
        return dp.get(0);
//        return dfs(0,n,k,maxPts);
    }

    public double dfs(int score, int n, int k, int maxPts) {
        if(score >= k) {
            return score <= n ? 1 : 0;
        }
        if(dp.containsKey(score)) {
            return dp.get(score);
        }
        double prob = 0;
        for(int i = 1; i <= maxPts; i++) {
            prob += dfs(score+i,n,k,maxPts);
        }
        dp.put(score,prob/maxPts);
        return dp.get(score);
    }
}
