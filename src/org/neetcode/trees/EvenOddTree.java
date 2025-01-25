package org.neetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val % 2 != 1) {
            return false;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root.left != null)
            queue.add(root.left);
        if(root.right != null)
            queue.add(root.right);
        boolean isEvenRow = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> row = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                row.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            if(!isValidRow(row, isEvenRow)) {
                return false;
            }
            isEvenRow = !isEvenRow;
        }
        return true;
    }

    public boolean isValidRow(List<Integer> row, boolean isEvenRow) {
        if(isEvenRow) {
            int prev = -1;
            for(int i = 0; i < row.size(); i++) {
                if(row.get(i)%2 != 1 || row.get(i) <= prev) {
                    return false;
                }
                prev = row.get(i);
            }
        } else {
            int prev = Integer.MAX_VALUE;
            for(int i = 0; i <row.size(); i++) {
                if(row.get(i)%2 != 0 || row.get(i) >= prev) {
                    return false;
                }
                prev = row.get(i);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode nodeLLR = new TreeNode(16, null, null);
        TreeNode nodeLLL = new TreeNode(18, null, null);
        TreeNode nodeLR = new TreeNode(9, null, null);
        TreeNode nodeLL = new TreeNode(5, nodeLLL, nodeLLR);
        TreeNode nodeR = new TreeNode(8, null, null);
        TreeNode nodeL = new TreeNode(12, nodeLL, nodeLR);
        TreeNode node = new TreeNode(2, nodeL, nodeR);
        EvenOddTree evenOddTree = new EvenOddTree();
        System.out.println(evenOddTree.isEvenOddTree(node));
    }
}
