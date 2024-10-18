package org.neetcode.stacks;

import org.neetcode.arrays.hashing.Pattern;

import java.util.Stack;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;
        for(int i = n-1; i >= 0; i--) {
            if(nums[i] < secondMax) {
                return true;
            }
            while(!stack.isEmpty() && stack.peek() < nums[i]) {
                secondMax = Math.max(stack.pop(), secondMax);
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,4,2};
        Pattern132 pattern132 = new Pattern132();
        System.out.println(pattern132.find132pattern(nums));
    }
}
