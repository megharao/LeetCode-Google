package org.neetcode.arrays.hashing;

import java.util.*;

public class MinOp2MakeArrEmpty {
    public static int minOperations(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int n : nums) {
            countMap.put(n, countMap.getOrDefault(n,0)+1);
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == 1) {
                return -1;
            }
            res += Math.ceilDiv(entry.getValue(), 3);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {19,19,19,19,19,19,19,19,19,19,19,19,19};
        System.out.println(minOperations(nums));
    }
}
