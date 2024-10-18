package org.neetcode.two.pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int a = 0; a <nums.length-3; a++) {
            if(a > 0 && nums[a] == nums[a-1]) {
                continue;
            }
            for(int i = a+1; i < nums.length-2; i++) {
                if(i > 1 && nums[i] == nums[i-1] && i-1 != a) {
                    continue;
                }
                int j = i+1;
                int k = nums.length-1;
                while(k > j) {
                    long sum = (long) nums[i] + nums[a] + nums[j] + nums[k];
                    if(sum==target) {
                        result.add(Arrays.asList(nums[i],nums[a],nums[j],nums[k]));
                        j++;
                        while(nums[j]==nums[j-1] && j < k) {
                            j++;
                        }
                    } else if(sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        FourSum fourSum = new FourSum();
        List<List<Integer>> res = fourSum.fourSum(nums,0);
        System.out.println(res);
    }
}
