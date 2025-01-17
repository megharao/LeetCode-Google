package org.neetcode.two.pointers;

import java.util.Arrays;

public class SortArrByParity {
    public static int[] sortArrayByParity(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length) {
            if(nums[right]%2 == 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                right++;
                left++;
            } else {
                right++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        Arrays.stream(sortArrayByParity(nums)).forEach(System.out::println);
    }
}
