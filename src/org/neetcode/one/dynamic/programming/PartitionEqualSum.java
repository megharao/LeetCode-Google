package org.neetcode.one.dynamic.programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSum {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 == 1) {
            return false;
        }
        Set<Integer> dp = new HashSet<>();
        dp.add(0);
        int target = sum/2;
        for(int i = nums.length-1; i >= 0; i--) {
            Set<Integer> nextDp = Set.copyOf(dp);
            for(Integer t: nextDp) {
                dp.add(t+nums[i]);
            }
        }
        if(dp.contains(target)) {
            return true;
        }
        return false;
    }
}
