package org.neetcode.arrays.hashing;

import java.util.Arrays;

public class Sort {
    public int[] sortArray(int[] nums) {
        if(nums.length <= 1) {
            return nums;
        }
        int mid = nums.length/2;
        int[] left = new int[mid];
        int[] right = new int[nums.length-mid];
        for(int i = 0; i < mid; i++) {
            left[i] = nums[i];
        }
        for(int i = mid; i < nums.length; i++) {
            right[i-mid] = nums[i];
        }
        sortArray(left);
        sortArray(right);
        merge(left,right,nums);
        return nums;
    }

    public void merge(int[] left, int[] right, int[] nums) {
        int i = 0, j = 0, k = 0;
        while(i < left.length && j < right.length) {
            if(left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < left.length) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while(j < right.length) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        Sort sort = new Sort();
        Arrays.stream(sort.sortArray(nums)).forEach(System.out::println);
    }
}
