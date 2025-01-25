package org.neetcode.trees;

public class DistributeCoinsInBinaryTree {
    int res = 0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public String dfs(TreeNode curr) {
        if(curr == null) {
            return "0#0"; //return size of subtree#numofcoins
        }
        String[] leftRes = dfs(curr.left).split("#");
        String[] rightRes = dfs(curr.right).split("#");
        int size = 1 + Integer.parseInt(leftRes[0]) + Integer.parseInt(rightRes[0]);
        int coins = curr.val + Integer.parseInt(leftRes[1]) + Integer.parseInt(rightRes[1]);
        res += Math.abs(size-coins);
        return size+"#"+coins;
    }

    public static void main(String[] args) {

    }
}
