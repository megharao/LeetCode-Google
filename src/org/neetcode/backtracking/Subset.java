package org.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, res, subset);
        return res;
    }

    public void dfs(int i, int[] nums, List<List<Integer>> res, List<Integer> subset) {
        if(i >= nums.length) {
            res.add(List.copyOf(subset));
            return;
        }
        subset.add(nums[i]);
        dfs(i+1, nums, res, subset);

        subset.remove(Integer.valueOf(nums[i]));
        dfs(i+1,nums,res, subset);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        Subset subset = new Subset();
        List<List<Integer>> list = subset.subsets(nums);
        for(List<Integer> l: list) {
            l.stream().forEach(System.out::print);
            System.out.println();
        }
    }
}
