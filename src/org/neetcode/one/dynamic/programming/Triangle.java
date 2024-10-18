package org.neetcode.one.dynamic.programming;

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
         int[] dp = new int[triangle.get(triangle.size()-1).size()+1];
         for(int row = triangle.size()-1; row >= 0; row--) {
             for(int i = 0; i < triangle.get(row).size(); i++) {
                 dp[i] = triangle.get(row).get(i) + Math.min(dp[i],dp[i+1]);
             }
         }
         return dp[0];
    }
}
