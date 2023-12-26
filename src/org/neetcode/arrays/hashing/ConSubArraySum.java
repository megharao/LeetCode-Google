package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class ConSubArraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        Map<Integer, Integer> reminderMap = new HashMap<>();
        reminderMap.put(0,-1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0) {
                sum %= k;
            }
            Integer prevIndex = reminderMap.get(sum);
            if(prevIndex != null) {
                if(i-prevIndex > 1) {
                    return true;
                }
            } else {
                reminderMap.put(sum,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,6,0,9,6,9};
        ConSubArraySum conSubArraySum = new ConSubArraySum();
        System.out.println(conSubArraySum.checkSubarraySum(nums,7));
    }
}
