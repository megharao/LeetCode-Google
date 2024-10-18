package org.neetcode.trees;

import java.util.*;
import java.util.stream.Collectors;

public class LevelOrderBST {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> data = new ArrayList<>();
        int[] a = new int[10];
        StringBuilder stringBuilder = new StringBuilder();
        String s = "abc";

        Queue<TreeNode> visited = new ArrayDeque<>();
        visited.add(root);
        while(!visited.isEmpty()) {
            int qLen = visited.size();
            List<Integer> d = new ArrayList<>();
            for(int i = 0; i < qLen; i++) {
                TreeNode temp = visited.poll();
                if(temp != null) {
                    d.add(temp.val);
                    if(temp.left != null)
                        visited.add(temp.left);
                    if(temp.right != null)
                        visited.add(temp.right);
                }
            }
            data.add(d);
        }
        return data;
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> node = new ArrayList<>();
        ArrayDeque<TreeNode> visited = new ArrayDeque<>();
        visited.add(root);
        while(!visited.isEmpty()) {
            TreeNode right = null;
            int qLen = visited.size();
            for(int i = 0; i < qLen; i++) {
                TreeNode left = visited.pollFirst();
                if (left != null) {
                    right = left;
                    if(left.left != null) visited.add(left.left);
                    if(left.right != null)visited.add(left.right);
                }
            }
            if(right != null)
                node.add(right.val);
        }
        return node;
    }
    public static void main(String[] args) {
        System.out.println('.'-'a');
        Set<String> s = new HashSet<>();
        List<String> sol = s.stream().collect(Collectors.toList());
        System.out.println(Integer.MAX_VALUE);
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        root.left = left;
        TreeNode right = new TreeNode(3);
        root.right = right;
        TreeNode rightL = new TreeNode(4);
        left.left = rightL;
        rightSideView(root).stream().forEach(System.out::println);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
