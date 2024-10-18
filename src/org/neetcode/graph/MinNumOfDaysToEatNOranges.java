package org.neetcode.graph;

public class MinNumOfDaysToEatNOranges {
    int[] dp;
    public int minDays(int n) {
        dp = new int[n];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        dp[1] = 1;
        return dfs(n);
    }

    public int dfs(int n) {
        if(dp[n] != -1) {
            return dp[n];
        }
        int one = 1 + (n%2) + dfs(n/2);
        int two = 1 + (n%3) + dfs(n/3);
        dp[n] = Math.min(one,two);
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
