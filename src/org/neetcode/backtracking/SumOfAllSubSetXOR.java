package org.neetcode.backtracking;

public class SumOfAllSubSetXOR {
    int[] nums;
    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        return dfs(0,0);
    }

    public int dfs(int i, int total) {
        if(i == nums.length) {
            return total;
        }
        return dfs(i+1, total^nums[i]) //include nums[i]
        + dfs(i+1, total); // not include nums[i]
    }

    public static void main(String[] args) {

    }
}
