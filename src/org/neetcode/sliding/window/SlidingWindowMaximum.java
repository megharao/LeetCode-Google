package org.neetcode.sliding.window;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int left = 0, right = 0, resi = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        while(right < nums.length) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.add(right);
            if(left > deque.getFirst()) {
                deque.pollFirst();
            }
            if(right+1 >= k) {
                res[resi] = nums[deque.getFirst()];
                resi++;
                left++;
            }
            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] res = maxSlidingWindow(nums, 3);
        for(int r: res) {
            System.out.print(r + " ");
        }
    }
}
