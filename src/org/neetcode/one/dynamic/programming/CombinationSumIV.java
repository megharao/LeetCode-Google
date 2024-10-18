package org.neetcode.one.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0,1);
        for(int total = 1; total <= target; total++) {
            dp.put(total,0);
            for(int n = 0; n < nums.length; n++) {
                dp.put(total, dp.get(total)+dp.getOrDefault(total-nums[n], 0));
            }
        }
        return dp.get(target);
    }
}
