package org.neetcode.trees;

public class BinaryTreeToStr {
    public String tree2str(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        dfs(root, stringBuilder);
        return stringBuilder.toString().substring(1,stringBuilder.length()-1);
    }

    public void dfs(TreeNode treeNode, StringBuilder stringBuilder) {
        if(treeNode == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(treeNode.val);
        if(treeNode.left == null && treeNode.right != null) {
            stringBuilder.append("()");
        }
        dfs(treeNode.left,stringBuilder);
        dfs(treeNode.right,stringBuilder);
        stringBuilder.append(")");
    }
}
