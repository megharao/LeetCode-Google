package org.neetcode.sliding.window;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MinOpToMakeArrContinuous {

    public int minOperations(int[] nums) {
        int len = nums.length;
        nums = Arrays.stream(nums).distinct().sorted().toArray();
        int res = len;
        int r = 0;
        for(int l = 0; l < nums.length; l++) {
            //range - nums[l] - nums[l]+len+1
            while(r < nums.length && nums[r] < nums[l]+len) {
                r++;
            }
            int win = r - l;
            res = Math.min(res, len-win);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
