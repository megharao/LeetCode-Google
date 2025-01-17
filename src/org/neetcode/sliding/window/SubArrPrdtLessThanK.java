package org.neetcode.sliding.window;

public class SubArrPrdtLessThanK {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, l = 0, prod = 1;
        for(int r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while(prod >= k && l <= r) {
                prod /= nums[l];
                l++;
            }
            res += (r-l+1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(numSubarrayProductLessThanK(nums, 1));
    }
}
