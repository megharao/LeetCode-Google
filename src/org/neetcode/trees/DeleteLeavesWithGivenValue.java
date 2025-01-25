package org.neetcode.trees;

import java.util.Deque;

public class DeleteLeavesWithGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        boolean res = dfs(root, target);
        if(res) {
            return null;
        }
        return root;
    }

    public boolean dfs(TreeNode root, int target) {
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                return true;
            }
            return false;
        }
        if(root.left != null) {
            boolean res = dfs(root.left, target);
            if (res) {
                root.left = null;
            }
        }
        if(root.right != null) {
            boolean res = dfs(root.right, target);
            if (res) {
                root.right = null;
            }
        }
        if(root.left == null && root.right == null) {
            if(root.val == target) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode nodeRR = new TreeNode(4, null, null);
        TreeNode nodeRL = new TreeNode(2, null, null);
        TreeNode nodeLL = new TreeNode(2, null, null);
        TreeNode nodeR = new TreeNode(3, nodeRL, nodeRR);
        TreeNode nodeL = new TreeNode(2, nodeLL, null);
        TreeNode node = new TreeNode(1, nodeL, nodeR);
        DeleteLeavesWithGivenValue deleteLeavesWithGivenValue = new DeleteLeavesWithGivenValue();
        deleteLeavesWithGivenValue.removeLeafNodes(node, 2);
    }
}
