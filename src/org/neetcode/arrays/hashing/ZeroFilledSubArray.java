package org.neetcode.arrays.hashing;

public class ZeroFilledSubArray {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0;
        int prevCount = 0;
        for(int n: nums) {
            if(n == 0) {
                count += 1+prevCount;
                prevCount++;
            } else {
                prevCount = 0;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,10,2019};
        ZeroFilledSubArray zeroFilledSubArray = new ZeroFilledSubArray();
        System.out.println(zeroFilledSubArray.zeroFilledSubarray(nums));
    }
}
