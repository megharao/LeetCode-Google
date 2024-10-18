package org.neetcode.one.dynamic.programming;

import java.util.Stack;

public class MaxSubArrMinProduct {
    public int maxSumMinProduct(int[] nums) {
        //We need a monotonic increasing stack
        //Consider if each Value was the min of subarray and make the subarrray as large as we possibly can
        Stack<long[]> stack = new Stack<>();
        long[] pre = new long[nums.length];
        pre[0] = nums[0];
        long res = 0, mod = (int) 1e9+7;
        for(int i = 1; i < nums.length; i++) {
            pre[i] = pre[i-1] + nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            int idx = i;
            while(!stack.isEmpty() && nums[i] < stack.peek()[1]) {
                long[] t = stack.pop();
                int start = (int) t[0];
                long value = t[1];
                long sum = pre[i-1] - ((start-1) < 0 ? 0: pre[start-1]);
                res = Math.max(res, (value*sum));
                idx = start;
            }
            stack.push(new long[]{idx,nums[i]});
        }
        while(!stack.isEmpty()) {
            long[] t = stack.pop();
            int start = (int) t[0];
            long value = t[1];
            long sum = pre[nums.length-1] - ((start-1) <0?0:pre[start-1]);
            res = Math.max(res, value*sum);
        }
        return (int) ((res+mod) % mod);
    }
}
