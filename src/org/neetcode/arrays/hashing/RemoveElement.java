package org.neetcode.arrays.hashing;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(val != nums[i]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {

    }
}
