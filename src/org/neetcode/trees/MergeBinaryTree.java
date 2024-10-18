package org.neetcode.trees;

public class MergeBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return dfs(root1,root2);
    }

    public TreeNode dfs(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        }
        if(root1 == null) {
            return root2;
        }
        else if(root2 == null) {
            return root1;
        } else {
            TreeNode node = new TreeNode(root1.val+root2.val);
            node.left = dfs(root1.left,root2.left);
            node.right = dfs(root1.right,root2.right);
            return node;
        }
    }
}
