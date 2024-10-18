package org.neetcode.trees;

import java.util.*;

public class AllPossibleFullBinaryTree {
    Map<Integer, List<TreeNode>> cache = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {
        if(n==0) {
            return new ArrayList<>();
        }
        if(n==1) {
            return new ArrayList<>(Arrays.asList(new TreeNode(0)));
        }
        if(cache.containsKey(n)) {
            return cache.get(n);
        }
        List<TreeNode> res = new ArrayList<>();
        for(int l = 0; l < n; l++) {
            int r = n-1-l;
            List<TreeNode> left = allPossibleFBT(l);
            List<TreeNode> right = allPossibleFBT(r);
            for(TreeNode t1: left) {
                for(TreeNode t2: right) {
                    TreeNode root = new TreeNode(0);
                    root.left = t1;
                    root.right = t2;
                    res.add(root);
                }
            }
        }
        cache.put(n,res);
        return res;
    }
}
