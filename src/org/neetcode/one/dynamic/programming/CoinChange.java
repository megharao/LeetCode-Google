package org.neetcode.one.dynamic.programming;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i = 0; i < dp.length; i++) {
            dp[i] = amount+1;
        }
        dp[0] = 0;
        for(int i = 1; i < amount+1 ; i++) {
            for(int c : coins) {
                if(i-c >= 0) {
                    dp[i] = Math.min(dp[i], 1+dp[i-c]);
                }
            }
        }
        if(dp[amount] != amount+1) {
            return dp[amount];
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins,11));
    }
}
