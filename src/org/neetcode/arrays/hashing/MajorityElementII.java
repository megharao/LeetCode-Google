package org.neetcode.arrays.hashing;

import java.util.*;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int n: nums) {
            countMap.put(n, countMap.getOrDefault(n,0)+1);
            if(countMap.size() <= 2) {
                continue;
            }
            Map<Integer, Integer> newCountMap = new HashMap<>();
            for(Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if(entry.getValue() > 1) {
                    newCountMap.put(entry.getKey(), entry.getValue()-1);
                }
            }
            countMap = newCountMap;
        }
        for(Map.Entry<Integer, Integer> entry: countMap.entrySet()) {
            if(Arrays.stream(nums).filter(i -> i == entry.getKey()).count() > Math.floor(nums.length/3)) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
