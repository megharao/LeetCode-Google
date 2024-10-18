package org.neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(res,new ArrayList<>(),nums,new boolean[nums.length]);
        return res;
    }

    public void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, boolean[] visited) {
        if(path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i > 0 && nums[i-1] == nums[i] && visited[i-1]))
                continue;
            visited[i] = true;
            path.add(nums[i]);
            backtrack(res,path,nums,visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(nums));
    }
}
