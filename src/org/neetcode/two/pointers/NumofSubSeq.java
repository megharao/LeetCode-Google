package org.neetcode.two.pointers;

import java.util.Arrays;

public class NumofSubSeq {
    public static int numSubseq(int[] nums, int target) {
        int count = 0;
        int mod = (int) (Math.pow(10,9)+7);
        Arrays.sort(nums);
        int[] exp = new int[nums.length];
        exp[0] = 1;
        for(int i = 1; i< nums.length; i++) {
            exp[i] = (exp[i-1]*2) % mod;
        }
        int i = 0, j = nums.length-1;
        while (i <= j) {
            if(nums[i] + nums[j] <= target) {
                count = (count + exp[j-i] ) % mod;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14};
        System.out.println(numSubseq(nums, 22));
    }
}
