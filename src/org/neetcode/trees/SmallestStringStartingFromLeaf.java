package org.neetcode.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestStringStartingFromLeaf {
    List<String> stringList = new ArrayList<>();
    public String smallestFromLeaf(TreeNode root) {
        dfs(root, String.valueOf((char) ('a' + root.val)));
        stringList.sort(String::compareTo);
        return stringList.get(0);
    }

    public void dfs(TreeNode root, String str) {
        if(root.left == null && root.right == null) {
            stringList.add(new StringBuilder(str).reverse().toString());
            return;
        }
        if(root.left != null) {
            str = str.concat(String.valueOf((char) ('a' + root.left.val)));
            dfs(root.left, str);
            str = str.substring(0, str.length() - 1);
        }
        if(root.right != null) {
            str = str.concat(String.valueOf((char) ('a' + root.right.val)));
            dfs(root.right, str);
        }
    }

    public String getString(String num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String digit : num.split("#")) {
            int numericValue = Integer.parseInt(digit.trim());
            // Convert the integer to a character by offsetting from 'a'
            char letter = (char) ('a' + numericValue);
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        TreeNode nodeRR = new TreeNode(7, null, null);
        TreeNode nodeRL = new TreeNode(15, null, null);
        TreeNode nodeLR = new TreeNode(4, null, null);
        TreeNode nodeLL = new TreeNode(3, null, null);
        TreeNode nodeR = new TreeNode(20, nodeRL, nodeRR);
        TreeNode nodeL = new TreeNode(9, null, null);
        TreeNode node = new TreeNode(3, nodeL, nodeR);
        SmallestStringStartingFromLeaf smallestStringStartingFromLeaf = new SmallestStringStartingFromLeaf();
        System.out.println(smallestStringStartingFromLeaf.smallestFromLeaf(node));
    }
}
