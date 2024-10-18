package org.neetcode.backtracking;

import java.util.Arrays;

public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int target = Arrays.stream(nums).sum()/k;
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used,false);
        return backtrack(0,k,0,target, nums, used);
    }

    public boolean backtrack(int i, int k, int subsetSum, int target, int[] nums, boolean[] used) {
        if(k==0) {
            return true;
        }
        if(subsetSum == target) {
            return backtrack(0,k-1,0,target, nums, used);
        }
        for(int j = i; j < nums.length; j++) {
            if(used[j] || subsetSum+nums[j] > target) {
                continue;
            }
            used[j] = true;
            if(backtrack(j+1,k,subsetSum+nums[j],target,nums,used)) {
                return true;
            }
            used[j] = false;
        }
        return false;
    }
}
