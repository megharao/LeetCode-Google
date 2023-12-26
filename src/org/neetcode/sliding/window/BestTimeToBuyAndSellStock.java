package org.neetcode.sliding.window;

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0, right = 1;
        while(right < prices.length) {
            if(prices[left] != 0 && prices[left] < prices[right]) {
                maxProfit = Math.max(maxProfit, prices[right]-prices[left]);
                right++;
            } else {
                left = right;
                right++;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
