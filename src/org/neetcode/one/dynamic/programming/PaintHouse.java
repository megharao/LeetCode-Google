package org.neetcode.one.dynamic.programming;

import java.util.Arrays;

public class PaintHouse {
    public int minCostToPaintHouse(int[][] costs) {
        //costs[i][j] i is house, j is color
        int[] dp = {0,0,0};
        for(int i = 0; i < costs.length; i++) {
            int dp0 = costs[i][0] + Math.min(dp[1],dp[2]);
            int dp1 = costs[i][1] + Math.min(dp[0],dp[2]);
            int dp2 = costs[i][2] + Math.min(dp[0],dp[1]);
            dp = new int[] {dp0, dp1, dp2};
        }
        return Arrays.stream(dp).min().getAsInt();
    }
}
