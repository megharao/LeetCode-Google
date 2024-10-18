package org.neetcode.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticTriplet {
    public static int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        for(int i =0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,9};
        System.out.print(arithmeticTriplets(nums, 2));
    }
}
