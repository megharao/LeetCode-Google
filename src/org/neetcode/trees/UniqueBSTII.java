package org.neetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class UniqueBSTII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }

    public List<TreeNode> generate(int left, int right) {
        List<TreeNode> list = new ArrayList<>();
        if(left > right) {
            list.add(null);
            return list;
        }
        for(int i = left; i <= right; i++) {
            List<TreeNode> leftTrees = generate(left,i-1);
            List<TreeNode> rightTrees = generate(i + 1, right);
            for(TreeNode leftTree: leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i,leftTree,rightTree);
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        UniqueBSTII uniqueBSTII = new UniqueBSTII();
        System.out.println(uniqueBSTII.generateTrees(3));
    }
}
