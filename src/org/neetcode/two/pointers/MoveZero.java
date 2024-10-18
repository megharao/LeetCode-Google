package org.neetcode.two.pointers;

public class MoveZero {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 1;
        while(j < nums.length) {
            if(nums[i] == 0) {
                if(nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j++;
                } else {
                    j++;
                }
            } else {
                i++;
                j++;
            }
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
        int[] nums = {0};
        MoveZero moveZero = new MoveZero();
        moveZero.moveZeroes(nums);
    }
}
