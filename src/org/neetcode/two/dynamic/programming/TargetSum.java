package org.neetcode.two.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    Map<String, Integer> dp = new HashMap<>();
    int[] nums;
    int target;
    public int findTargetSumWays(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        return dfs(0,0);
    }

    public int dfs(int index, int total) {
        if(index == nums.length) {
            return total == target ? 1 : 0;
        }
        if(dp.containsKey(index+"#"+total)) {
            return dp.get(index+"#"+total);
        }
        dp.put(index+"#"+total,dfs(index+1, total+nums[index])+dfs(index+1,total-nums[index]));
        return dp.get(index+"#"+total);
    }


}
