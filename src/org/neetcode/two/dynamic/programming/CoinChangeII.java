package org.neetcode.two.dynamic.programming;

import java.util.Arrays;

public class CoinChangeII {
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i],-1);
        Arrays.sort(coins);
        return count(0,dp,coins,amount);
    }

    public int count(int i,int[][] dp,int[] coins,int amount){
        if(amount==0)
            return 1;
        if(i<coins.length){
            if(dp[i][amount]==-1){
                if(coins[i]>amount)
                    return 0;
                return dp[i][amount]=count(i,dp,coins,amount-coins[i])+count(i+1,dp,coins,amount);
            }
            return dp[i][amount];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        CoinChangeII coinChangeII = new CoinChangeII();
        System.out.println(coinChangeII.change(5,coins));
    }
}
