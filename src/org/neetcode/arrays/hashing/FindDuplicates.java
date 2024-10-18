package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int n : nums) {
            n = Math.abs(n);
            int index = n-1;
            if(nums[index] < 0) {
                res.add(n);
            } else {
                nums[index] = nums[index] * -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        findDuplicates(nums);
    }
}
