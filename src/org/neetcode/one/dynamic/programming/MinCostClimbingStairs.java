package org.neetcode.one.dynamic.programming;

import java.util.Arrays;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] copy = Arrays.copyOf(cost, cost.length+1);

        for(int i = copy.length-3; i >= 0; i--) {
            copy[i] = copy[i] + Math.min(copy[i+1], copy[i+2]);
        }
        return Math.min(copy[0],copy[1]);
    }

    public static void main(String[] args) {
        int[] cost = {10,15,20};
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        System.out.println(minCostClimbingStairs.minCostClimbingStairs(cost));
    }
}
