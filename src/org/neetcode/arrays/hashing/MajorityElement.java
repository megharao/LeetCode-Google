package org.neetcode.arrays.hashing;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1, res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(res == nums[i]) {
                count++;
            } else {
                if(count > 0) {
                    count--;
                } else {
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
