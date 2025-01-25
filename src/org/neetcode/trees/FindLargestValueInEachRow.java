package org.neetcode.trees;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachRow {
    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
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
            res.add(row.stream().max(Integer::compare).get());
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNodeRR = new TreeNode(9, null, null);
        TreeNode treeNodeLR = new TreeNode(3, null, null);
        TreeNode treeNodeLL = new TreeNode(5, null, null);
        TreeNode treeNodeR = new TreeNode(2, null, treeNodeRR);
        TreeNode treeNodeL = new TreeNode(3, treeNodeLL, treeNodeLR);
        TreeNode treeNode = new TreeNode(1, treeNodeL, treeNodeR);
        System.out.println(largestValues(treeNode));
    }
}
