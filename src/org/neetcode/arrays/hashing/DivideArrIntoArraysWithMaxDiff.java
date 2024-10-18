package org.neetcode.arrays.hashing;

import java.util.Arrays;

public class DivideArrIntoArraysWithMaxDiff {
    public static int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] res = new int[nums.length/3][3];
        int j = 0;
        for(int i = 0; i < nums.length; i=i+3) {
            if(nums[i+2] - nums[i] > k) {
                return new int[0][0];
            }
            int[] inner = new int[3];
            inner[0] = nums[i];
            inner[1] = nums[i+1];
            inner[2] = nums[i+2];
            res[j] = inner;
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,8,7,9,3,5,1};
        System.out.println(divideArray(nums, 2));
    }
}
