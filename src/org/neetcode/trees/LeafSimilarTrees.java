package org.neetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1Leaves = getLeaves(root1, new ArrayList<>());
        List<Integer> root2Leaves = getLeaves(root2, new ArrayList<>());
        boolean res = true;
        if(root1Leaves.size() != root2Leaves.size()) {
            return false;
        }
        for(int i = 0; i < root1Leaves.size(); i++) {
            if(root1Leaves.get(i).compareTo(root2Leaves.get(i)) != 0) {
                return false;
            }
        }
        return res;
    }

    public List<Integer> getLeaves(TreeNode root1, List<Integer> list) {
        if(root1 == null) {
            return list;
        }
        if(root1.left == null && root1.right == null) {
            list.add(root1.val);
            return list;
        } else {
            getLeaves(root1.left, list);
            getLeaves(root1.right, list);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root1R = new TreeNode(200,null, null);
        TreeNode root1L = new TreeNode(2,null, null);
        TreeNode root1 = new TreeNode(1,root1L, root1R);

        TreeNode root2 = new TreeNode(1,root1L, root1R);

        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        System.out.println(leafSimilarTrees.leafSimilar(root1,root2));
    }
}
