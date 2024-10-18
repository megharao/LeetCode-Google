package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class MonotonicArray {
    public static boolean isMonotonic(int[] nums) {
        boolean isIncr = true, isDecr = true;
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] < nums[i+1])
                isDecr = false;
            else if(nums[i] > nums[i+1])
                isIncr = false;
        }
        return isDecr || isIncr;
    }

    public static void main(String[] args) {
        int[] nums = {6,5,4,4};
        isMonotonic(nums);
    }
}
