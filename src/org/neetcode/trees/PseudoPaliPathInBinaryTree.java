package org.neetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class PseudoPaliPathInBinaryTree {
    Map<Integer, Integer> count = new HashMap<>(); //digit -> count
    int odd = 0; //digits with odd count
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root);

    }

    public int dfs(TreeNode curr) {
        if(curr == null) {
            return 0;
        }
        count.put(curr.val, count.getOrDefault(curr.val,0)+1);
        int odd_change = count.get(curr.val) % 2 == 1 ? 1 : -1;
        odd += odd_change;
        int res;
        if(curr.left == null && curr.right == null) {
            res = odd <= 1 ? 1 : 0;
        } else {
            res = dfs(curr.left) + dfs(curr.right);
        }
        odd -= odd_change;
        count.put(curr.val, count.getOrDefault(curr.val,0)-1);
        return res;
    }
}
