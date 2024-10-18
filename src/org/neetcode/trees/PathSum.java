package org.neetcode.trees;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public boolean dfs(TreeNode root, int targetSum, int currSum) {
        if(root == null) {
            return false;
        }
        currSum += root.val;
        if(root.left == null && root.right == null) {
            return targetSum==currSum;
        }
        return dfs(root.left,targetSum,currSum) || dfs(root.right,targetSum,currSum);
    }
}
