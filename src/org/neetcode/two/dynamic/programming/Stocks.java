package org.neetcode.two.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class Stocks {
    int[] prices ;
    Map<String, Integer> dp;
    public int maxProfit(int[] prices) {
        // Buy or Sell?
        // Buy - i+1
        // Sell - i+2 bcoz cooldown
        this.prices = prices;
        dp = new HashMap<>();
        return dfs(0,true);
    }

    public int dfs(int i, boolean isBuy) {
        if(i >= prices.length) {
            return 0;
        }
        if(dp.containsKey(i+"#"+isBuy)) {
            return dp.get(i+"#"+isBuy);
        }
        if(isBuy) {
            int buy = dfs(i+1, !isBuy) - prices[i];
            int cooldown = dfs(i+1, isBuy);
            dp.put(i+"#"+isBuy,Math.max(buy, cooldown));
        } else {
            int sell = dfs(i+2, !isBuy) + prices[i];
            int cooldown = dfs(i+1, isBuy);
            dp.put(i+"#"+isBuy,Math.max(sell, cooldown));
        }
        return dp.get(i+"#"+isBuy);
    }

    public static void main(String[] args) {

    }
}


