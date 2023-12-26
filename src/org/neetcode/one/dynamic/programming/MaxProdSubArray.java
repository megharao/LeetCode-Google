package org.neetcode.one.dynamic.programming;

public class MaxProdSubArray {
    public int maxProduct(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int res = 0;
        int currMin = 1, currMax = 1;
        for(int i: nums) {
            if(i == 0) {
                currMax = 1;
                currMin = 1;
                continue;
            }
            int temp = currMax;
            currMax = Math.max(i,Math.max(currMax*i, currMin*i));
            currMin = Math.min(i,Math.min(temp*i, currMin*i));
            res = Math.max(res, currMax);
        }
        return res;
    }
}
