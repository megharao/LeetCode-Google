package org.neetcode.sliding.window;

public class MinSizeSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r= 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while(r < nums.length) {
            if(sum < target) {
                sum += nums[r];
                r++;
            } else {
                while(sum >= target) {
                    minLen = Math.min(minLen, r - l);
                    sum -= nums[l];
                    l++;
                }
            }
        }
        while(sum >= target) {
            minLen = Math.min(minLen, r - l);
            sum -= nums[l];
            l++;
        }
        return minLen == Integer.MAX_VALUE ? 0: minLen;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1,1,1,1};
        MinSizeSubArray minSizeSubArray = new MinSizeSubArray();
        System.out.println(minSizeSubArray.minSubArrayLen(11,nums));
    }
}
