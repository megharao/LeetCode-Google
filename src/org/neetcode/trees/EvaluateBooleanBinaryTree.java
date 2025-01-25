package org.neetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EvaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val == 0 ? false : true;
        }
        boolean left = evaluateTree(root.left);
        boolean right = evaluateTree(root.right);
        if(root.val == 2) {
            return left || right;
        }else {
            return left && right;
        }
    }

    public static void main(String[] args) {
        TreeNode rootRR = new TreeNode(1,null, null);
        TreeNode rootRL = new TreeNode(0,null, null);
        TreeNode rootR = new TreeNode(3,rootRL, rootRR);
        TreeNode rootL = new TreeNode(1,null, null);
        TreeNode root = new TreeNode(2,rootL, rootR);

        EvaluateBooleanBinaryTree evaluateBooleanBinaryTree = new EvaluateBooleanBinaryTree();
        System.out.println(evaluateBooleanBinaryTree.evaluateTree(root));
    }
}
