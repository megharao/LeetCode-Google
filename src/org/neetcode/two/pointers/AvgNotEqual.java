package org.neetcode.two.pointers;

import java.util.Arrays;

public class AvgNotEqual {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        int j = 0;
        for(int i = 0; i < nums.length; i=i+2) {
            res[i] = nums[j];
            j++;
        }
        for(int i = 1; i < nums.length; i=i+2) {
            res[i] = nums[j];
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6,2,0,9,7};
        AvgNotEqual avgNotEqual = new AvgNotEqual();
        System.out.println(avgNotEqual.rearrangeArray(nums));
    }
}
