package org.neetcode.one.dynamic.programming;

import java.util.Arrays;

public class HouseRobber {

    /*public int rob(int[] nums) {
        return Math.max(rob2(Arrays.copyOfRange(nums,0,nums.length-1)),
                rob2(Arrays.copyOfRange(nums,1,nums.length)));
    }
    public int rob2(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length+1);
        for(int i = copy.length-3; i >= 0; i--) {
            copy[i] = Math.max(copy[i+1], copy[i]+copy[i+2]);
        }
        return Math.max(copy[0],copy[1]);
    }*/

    public int rob(int[] nums) {
        int rob1 = 0, rob2 = 0;
        //[rob1,rob2, n, n+1...]
        for(int n: nums) {
            int temp = Math.max(n+rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        return rob2;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(nums));
    }
}
