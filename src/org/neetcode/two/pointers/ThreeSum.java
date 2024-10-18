package org.neetcode.two.pointers;

import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            int l = i+1, r = nums.length-1;
            while(l < r) {
                int threesum = nums[i] + nums[l] + nums [r];
                if(threesum > 0) {
                    r -= 1;
                } else if(threesum < 0) {
                    l += 1;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[l], nums[r]);
                    l += 1;
                    result.add(list);
                    while(nums[l] == nums[l-1] && l < r) {
                        l += 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> list : result) {
            for(Integer i: list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }
}
