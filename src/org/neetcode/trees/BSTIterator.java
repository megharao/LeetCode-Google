package org.neetcode.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class BSTIterator {

    TreeNode root;

    Queue<Integer> traversal;
    public BSTIterator(TreeNode root) {
        this.root = root;
        traversal = new ArrayDeque<>();
        fillStack(root);
    }

    public void fillStack(TreeNode root) {
        if(root.left != null) {
            fillStack(root.left);
        }
        traversal.add(root.val);
        if(root.right!=null) {
            fillStack(root.right);
        }
    }

    public int next() {
        while(!traversal.isEmpty()) {
            return traversal.poll();
        }
        return -1;
    }

    public boolean hasNext() {
        return !traversal.isEmpty();
    }
}
