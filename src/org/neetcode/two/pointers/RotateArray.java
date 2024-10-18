package org.neetcode.two.pointers;

import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int l = 0, r = nums.length-1;
        while(l < r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
        l = 0; r = k-1;
        while(l < r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
        l = k; r = nums.length-1;
        while(l < r) {
            int temp = nums[r];
            nums[r] = nums[l];
            nums[l] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        RotateArray rotateArray = new RotateArray();
        rotateArray.rotate(nums,3);
    }
}
