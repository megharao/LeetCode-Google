package org.neetcode.one.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class ValidPartitionForTheArray {
    /**
     * Caching/Memoization solution
     */
    Map<Integer, Boolean> dp;
    public boolean validPartition(int[] nums) {
        dp = new HashMap<>();
        return dfs(0, nums);
    }

    public boolean dfs(int i, int[] nums) {
        if(i == nums.length) {
            return true;
        }
        if(dp.containsKey(i)) {
            return dp.get(i);
        }
        boolean result = false;
        if(i < nums.length-1 && nums[i] == nums[i+1]) {
            result = dfs(i+2,nums);
        }
        if( i < nums.length-2) {
            if((nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) || (nums[i]+1 == nums[i+1] && nums[i+1] == nums[i+2]-1)) {
                result = result || dfs(i + 3, nums);
            }
        }
        dp.put(i,result);
        return result;
    }
    /**
     * Dynamic Programming solution
     */
    public boolean validPartitionDP(int[] nums) {
        boolean two = nums[nums.length-1] == nums[nums.length-2];
        if(nums.length == 2) {
            return two;
        }
        boolean three = (nums[nums.length-1] == nums[nums.length-2] && nums[nums.length-2] == nums[nums.length-3]) || (nums[nums.length-3]+1 == nums[nums.length-2] && nums[nums.length-2] == nums[nums.length-1]-1);
        boolean[] dp = new boolean[]{three,two,false};
        for(int i = nums.length-4; i >= 0; i--) {
            boolean curr = (nums[i] == nums[i+1]) && dp[1];
            curr = curr || (((nums[i] == nums[i+1] && nums[i+1] == nums[i+2]) || (nums[i]+1 == nums[i+1] && nums[i+1] == nums[i+2]-1)) && dp[2]);
            dp = new boolean[] {curr, dp[0], dp[1]};
        }
        return dp[0];
    }
}
