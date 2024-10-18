package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumOfGoodPairs {
    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(); //num->count
        for(int i = 0; i < nums.length; i++) {
            int count = 0;
            if(map.containsKey(nums[i])) {
                count = map.get(nums[i]);
            }
            map.put(nums[i], count+1);
        }
        int res = 0;
        for(int c : map.values()) {
            res += (c*(c-1))/2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        numIdenticalPairs(nums);
    }
}
