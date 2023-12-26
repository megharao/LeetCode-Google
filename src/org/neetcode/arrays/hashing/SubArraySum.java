package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        int sum = 0;
        Map<Integer, Integer> count = new HashMap<>();//prefix->count
        count.put(0,1);
        for(int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            int diff = sum-k;
            total += count.getOrDefault(diff,0);
            count.put(sum, 1+count.getOrDefault(sum,0));
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        SubArraySum subArraySum = new SubArraySum();
        System.out.println(subArraySum.subarraySum(nums,3));
    }
}
