package org.neetcode.trees;

import java.util.LinkedList;
import java.util.Queue;

public class WidthOfBT {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root,1,0));
        int prevLevel = 0,  prevNum = 1;
        while (!queue.isEmpty()) {
            Tuple curr = queue.poll();
            TreeNode node = curr.node;
            int num = curr.num, level = curr.level;
            if(level > prevLevel) {
                prevLevel = level;
                prevNum = num;
            }
            res = Math.max(res,num-prevNum+1);
            if(node.left != null)
                queue.add(new Tuple(node.left,num*2,level+1));
            if(node.right != null)
                queue.add(new Tuple(node.right,num*2+1,level+1));
        }
        return res;
    }

    class Tuple {
        TreeNode node;
        int num;
        int level;

        public Tuple(TreeNode node, int num, int level) {
            this.node = node;
            this.num = num;
            this.level = level;
        }
    }
}
