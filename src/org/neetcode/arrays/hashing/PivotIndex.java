package org.neetcode.arrays.hashing;

import java.util.Arrays;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int index = -1;
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        int rightSum = sum;
        for(int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if(leftSum==rightSum) {
                return i;
            } else {
                leftSum += nums[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,-1};
        PivotIndex pivotIndex = new PivotIndex();
        System.out.println(pivotIndex.pivotIndex(nums));
    }
}
