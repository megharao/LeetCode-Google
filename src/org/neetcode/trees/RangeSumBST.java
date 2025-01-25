package org.neetcode.trees;

public class RangeSumBST {
    public static int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            if(root.val >= low && root.val <= high) {
                return root.val;
            } else {
                return 0;
            }
        }
        if(root.val <= low) {
            return (root.val >= low && root.val <= high ? root.val : 0)  + rangeSumBST(root.right, low, high);
        } else if(root.val >= high) {
            return (root.val >= low && root.val <= high ? root.val : 0)  + rangeSumBST(root.left, low, high);
        } else {
            return (root.val >= low && root.val <= high ? root.val : 0) + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }

    public static void main(String[] args) {
        //[10,5,15,3,7,null,18]
        TreeNode rootRR = new TreeNode(18,null, null);
        TreeNode rootRL = new TreeNode(13,null, null);
        TreeNode rootLRL = new TreeNode(6,null, null);
        TreeNode rootLR = new TreeNode(7,rootLRL, null);
        TreeNode rootLLL = new TreeNode(1,null, null);
        TreeNode rootLL = new TreeNode(3,rootLLL, null);
        TreeNode rootR = new TreeNode(15,rootRL, rootRR);
        TreeNode rootL = new TreeNode(5,rootLL, rootLR);
        TreeNode root = new TreeNode(10, rootL, rootR);
        System.out.println(rangeSumBST(root,6,10));
    }
}
