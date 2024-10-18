package org.neetcode.two.pointers;

import java.util.Arrays;
import java.util.Map;

public class MinDiff {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int l = 0, r = k-1;
        while(r < nums.length) {
            diff = Math.min(diff, nums[r]-nums[l]);
            l++;
            r++;
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        MinDiff minDiff = new MinDiff();
        System.out.println(minDiff.minimumDifference(nums,2));
    }
}
