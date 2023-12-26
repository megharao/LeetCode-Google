package org.neetcode.greedy;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = 0;
        for(int n : nums) {
            if(currSum <0) {
                currSum =0;
            }
            currSum += n;
            max = Math.max(max,currSum);
        }
        return max;
    }

    public static void main(String[] args) {

    }
}
