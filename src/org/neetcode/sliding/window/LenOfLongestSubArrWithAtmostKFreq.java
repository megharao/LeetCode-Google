package org.neetcode.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LenOfLongestSubArrWithAtmostKFreq {
    public static int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        int l = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r < nums.length; r++) {
            if(map.containsKey(nums[r])) {
                int count = map.get(nums[r]);
                map.put(nums[r], count+1);
                if(map.get(nums[r]) > k) {
                    while(map.get(nums[r]) > k) {
                        map.put(nums[l], map.get(nums[l])-1);
                        l++;
                    }
                }
            } else {
                map.put(nums[r],1);
            }
            res = Math.max(res, r-l+1);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,4,3};
        int k = 1;
        System.out.println(maxSubarrayLength(nums, k));
    }
}
