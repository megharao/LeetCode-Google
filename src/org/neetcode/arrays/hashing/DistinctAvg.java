package org.neetcode.arrays.hashing;

import java.util.*;



public class DistinctAvg {
    public static int distinctAverages(int[] nums) {
        Set<Double> avg = new HashSet<>();
        Arrays.sort(nums);
        int l = 0, r = nums.length-1;
        while(l < r) {
            double val = (nums[l]+nums[r])/2.0;
            avg.add(val);
            l++;
            r--;
        }
        return avg.size();
    }

    public static void main(String[] args) {
        int[] nums = {9,5,7,8,7,9,8,2,0,7};
        System.out.print(distinctAverages(nums));
    }
}
