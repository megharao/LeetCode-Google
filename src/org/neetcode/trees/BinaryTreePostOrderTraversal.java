package org.neetcode.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostOrderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Stack<Boolean> visited = new Stack<>();
        visited.push(false);
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            boolean v = visited.pop();
            if(curr != null) {
                if(v != false) {
                    res.add(curr.val);
                } else {
                    stack.push(curr);
                    visited.push(true);
                    stack.push(curr.right);
                    visited.push(false);
                    stack.push(curr.left);
                    visited.push(false);
                }
            }
        }
        return res;
    }
}
