package org.neetcode.trees;

public class InsertToBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        TreeNode curr = root;
        TreeNode prev = null;
        while(curr != null) {
            if(val > curr.val) {
                prev = curr;
                curr = curr.right;
            } else {
                prev = curr;
                curr = curr.left;
            }
        }
        TreeNode node = new TreeNode(val);
        if(val > prev.val) {
            prev.right = node;
        } else {
            prev.left = node;
        }
        return root;
    }

    public TreeNode insertIntoBSTR(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(val > root.val) {
            root.right = insertIntoBSTR(root.right,val);
        } else {
            root.left = insertIntoBSTR(root.left,val);
        }
        return root;
    }
}
