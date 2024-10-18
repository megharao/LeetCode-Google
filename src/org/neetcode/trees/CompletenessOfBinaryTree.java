package org.neetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class CompletenessOfBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean end = false;
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                if(end) {
                    return false;
                }
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                end = true;
            }
        }
        return true;
    }
}
