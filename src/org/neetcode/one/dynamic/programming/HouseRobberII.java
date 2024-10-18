package org.neetcode.one.dynamic.programming;

import java.util.Arrays;

public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums.length ==1) {
            return nums[0];
        }
        return Math.max(robI(Arrays.copyOfRange(nums,0,nums.length-1)), robI(Arrays.copyOfRange(nums,1,nums.length)));
    }

    public int robI(int[] nums) {
        int rob1 = 0, rob2 = 0;
        for(int n: nums) {
            int temp = Math.max(n+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }
}
