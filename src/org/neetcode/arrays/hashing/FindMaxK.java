package org.neetcode.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class FindMaxK {
    public static int findMaxK(int[] nums) {
        int max = Integer.MIN_VALUE;
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(visited.contains(-(nums[i]))) {
                max = Math.max(max, Math.abs(nums[i]));
            }
            visited.add(nums[i]);
        }
        if(max == Integer.MIN_VALUE) {
            return -1;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-1,10,6,7,-7,1};
        System.out.println(findMaxK(nums));
    }
}
