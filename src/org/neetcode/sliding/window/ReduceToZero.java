package org.neetcode.sliding.window;

import java.util.Arrays;

public class ReduceToZero {
    public int minOperations(int[] nums, int x) {
        int currSum = 0;
        int target = Arrays.stream(nums).sum() - x;
        int maxWin = -1;
        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while(l <= r && currSum > target) {
                currSum -= nums[l];
                l++;
            }
            if(currSum == target) {
                maxWin = Math.max(maxWin, r-l+1);
            }
        }
        return maxWin == -1 ? -1 : nums.length - maxWin;
    }

    public static void main(String[] args) {

    }
}
