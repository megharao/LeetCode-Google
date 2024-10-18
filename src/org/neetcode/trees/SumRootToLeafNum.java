package org.neetcode.trees;

public class SumRootToLeafNum {
    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }

    public int findSum(TreeNode root, int currSum) {
        if(root == null) {
            return 0;
        }
        currSum = currSum*10+root.val;
        if(root.left == null && root.right == null) {
            return currSum;
        }
        return findSum(root.left,currSum) +findSum(root.right,currSum);
    }
}
