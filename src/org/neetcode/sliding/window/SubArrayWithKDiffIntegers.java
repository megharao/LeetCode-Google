package org.neetcode.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubArrayWithKDiffIntegers {
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int res = 0;
        int leftFar = 0, leftNear = 0;
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(int r = 0; r < nums.length; r++) {
            numToCount.put(nums[r], numToCount.getOrDefault(nums[r], 0)+1);
            while(numToCount.size() > k) {
                numToCount.put(nums[leftNear], numToCount.get(nums[leftNear]) - 1);
                if(numToCount.get(nums[leftNear]) == 0) {
                    numToCount.remove(nums[leftNear]);
                }
                leftNear++;
                leftFar = leftNear;
            }
            while(numToCount.get(nums[leftNear]) > 1) {
                numToCount.put(nums[leftNear], numToCount.get(nums[leftNear]) - 1);
                leftNear++;
            }
            if(numToCount.size() == k) {
                res += leftNear - leftFar + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }
}
