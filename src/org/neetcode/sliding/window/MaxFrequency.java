package org.neetcode.sliding.window;

import java.util.Arrays;

public class MaxFrequency {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        int res = 0, total = 0;
        while(r < nums.length) {
            total += nums[r];
            while(nums[r]*(r-l+1) > total +k) {
                total -= nums[l];
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
