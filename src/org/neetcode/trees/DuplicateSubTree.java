package org.neetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubTree {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, List<TreeNode>> subTrees = new HashMap<>();
        List<TreeNode> res = new ArrayList<>();
        dfs(root,subTrees,res);
        return res;
    }

    public String dfs(TreeNode node,Map<String, List<TreeNode>> subTrees,List<TreeNode> res) {
        if(node == null) {
            return "null";
        }
        int value = node.val;
        String left = dfs(node.left,subTrees,res);
        String right = dfs(node.right,subTrees,res);
        String key = value+","+left+","+right;
        if(subTrees.containsKey(key) && subTrees.get(key).size() == 1) {
            res.add(node);
        }
        if(!subTrees.containsKey(key)) {
            subTrees.put(key,new ArrayList<>());
        }
        subTrees.get(key).add(node);
        return key;
    }
}
