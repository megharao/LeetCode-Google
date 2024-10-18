package org.neetcode.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructBTFromInOrderAndPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return buildTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1,map);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int posStart, int posEnd, Map<Integer, Integer> map) {
        if(inStart > inEnd || posStart > posEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[posEnd]);
        int rootIndex = map.get(root.val);
        int leftSize = rootIndex - inStart;
        root.left = buildTree(inorder,postorder,inStart,rootIndex-1,posStart,posStart+leftSize-1,map);
        root.right = buildTree(inorder,postorder,inStart+leftSize+1,inEnd,posStart+leftSize,posEnd-1,map);
        return root;
    }
}
