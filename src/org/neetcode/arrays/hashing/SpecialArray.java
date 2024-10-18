package org.neetcode.arrays.hashing;

import java.util.Arrays;

public class SpecialArray {
    public static int specialArray(int[] nums) {
        int[] count = new int[nums.length+1];
        for(int n : nums) {
            int index = n < nums.length ? n : nums.length;
            count[index] += 1;
        }
        int total_right = 0;
        for(int i = count.length-1; i >= 0; i++) {
            total_right += count[i];
            if(i==total_right) {
                return total_right;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        System.out.println(specialArray(nums));
    }
}
