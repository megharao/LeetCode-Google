package org.neetcode.sliding.window;

public class BinarySubArrWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return countSubArrSumWithSumLessThanEq(nums, goal) - countSubArrSumWithSumLessThanEq(nums, goal-1);
    }

    public static int countSubArrSumWithSumLessThanEq(int[] nums, int goal) {
        if(goal<0) {
            return 0;
        }
        int res = 0, l = 0, currSum = 0;
        for(int r = 0; r < nums.length; r++) {
            currSum += nums[r];
            while (currSum > goal) {
                currSum -= nums[l];
                l++;
            }
            res += (r-l+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0};
        System.out.println(numSubarraysWithSum(nums, 0));
    }
}
