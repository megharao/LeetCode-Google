package org.neetcode.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root,0));
        Pair ans = new Pair(root,0);
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int currLevel = curr.level;
            if(node.left != null)
                queue.add(new Pair(node.left,currLevel+1));
            if(node.right != null)
                queue.add(new Pair(node.right,currLevel+1));
            if(ans.level < currLevel) {
                ans = curr;
            }
        }
        return ans.node.val;
    }

    class Pair {
        TreeNode node;
        int level;
        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
