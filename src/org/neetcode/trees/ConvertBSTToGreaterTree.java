package org.neetcode.trees;

public class ConvertBSTToGreaterTree {
    int currSum = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    public void dfs(TreeNode node) {
         if(node == null) {
             return;
         }
         dfs(node.right);
         int temp = node.val;
         node.val += currSum;
         currSum += temp;
         dfs(node.left);
    }

    public static void main(String[] args) {
        TreeNode Zero = new TreeNode(0);
        TreeNode One = new TreeNode(1);
        TreeNode Two = new TreeNode(2);
        TreeNode Three = new TreeNode(3);
        TreeNode Four = new TreeNode(4);
        TreeNode Five = new TreeNode(5);
        TreeNode Six = new TreeNode(6);
        TreeNode Seven = new TreeNode(7);
        TreeNode Eight = new TreeNode(8);
        Seven.right = Eight;
        Six.left = Five;
        Six.right = Seven;
        Four.right = Six;
        Two.right = Three;
        One.right = Two;
        One.left = Zero;
        Four.left = One;
        ConvertBSTToGreaterTree convertBSTToGreaterTree = new ConvertBSTToGreaterTree();
        TreeNode treeNode = convertBSTToGreaterTree.convertBST(Four);
        System.out.println(treeNode);
    }
}
