package org.neetcode.one.dynamic.programming;

import java.util.Arrays;

public class PerfectSquare {
    public int numSquares(int n) {
        /**
         * Bottom up approach
         */
        int[] dp = new int[n+1];
        Arrays.fill(dp,n);//Fill array initially with a large number or Integer.MAX_VALUE
        dp[0] = 0;//base case - number of ways to get to n if n=0 is 0
        for(int target = 1; target <= n; target++) { //then calculate for each number from 1.2...n
            for(int s = 1; s <= target; s++) { //if 1^2..2^.. target^2 can be an option
                int square = s*s;
                if(target-square <0) {
                    break;
                }
                dp[target] = Math.min(dp[target], 1+dp[target-square]);
            }
        }
        return dp[n];
    }
}
