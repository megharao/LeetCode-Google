package org.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, int[] nums) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(list.contains(nums[i])) continue;
                list.add(nums[i]);
                dfs(res, list, nums);
                list.remove(Integer.valueOf(nums[i]));
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permutations permutations = new Permutations();
        List<List<Integer>> res = permutations.permute(nums);
        for(List<Integer> list : res) {
            list.stream().forEach(System.out::print);
            System.out.println();
        }
    }
}
