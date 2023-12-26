package org.neetcode.one.dynamic.programming;

import java.util.Arrays;

public class LIS {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        for(int i = 0; i <nums.length; i++) {
            lis[i] = 1;
        }
        for(int i = nums.length-2; i >= 0; i--) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    lis[i] = Math.max(lis[i],1+lis[j]);
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }
}
