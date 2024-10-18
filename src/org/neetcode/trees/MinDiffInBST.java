package org.neetcode.trees;

import java.util.Stack;

public class MinDiffInBST {
    int min = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);
        if(prev != null) {
            min = Math.min(min, Math.abs(prev.val - root.val));
        }
        prev = root;
        dfs(root.right);
    }


}
