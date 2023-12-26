package org.neetcode.bit.manipulation;

public class MissingNum {
    public int missingNumber(int[] nums) {
        int n = nums.length*(nums.length+1)/2;
        for(int i = 0; i < nums.length; i++) {
            n -= nums[i];
        }
        return n;
    }

    public static void main(String[] args) {
        MissingNum missingNum = new MissingNum();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNum.missingNumber(nums));
    }
}
