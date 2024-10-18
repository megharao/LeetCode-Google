package org.neetcode.arrays.hashing;

import java.util.Arrays;

public class SumOfAbsDiffInSortedArr {
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int total = Arrays.stream(nums).sum();
        int leftSum = 0;
        for(int i= 0; i < nums.length; i++) {
            int rightSum = total - nums[i] - leftSum;
            int leftSize = i;
            int rightSize = nums.length-i-1;
            res[i] = (leftSize*nums[i]) - leftSum + rightSum - (rightSize * nums[i]);
            leftSum += nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,6,8,10};
        Arrays.stream(getSumAbsoluteDifferences(nums)).forEach(i -> System.out.print(i + " "));
    }
}
