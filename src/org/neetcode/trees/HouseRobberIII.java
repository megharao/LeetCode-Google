package org.neetcode.trees;

import java.util.Arrays;

public class HouseRobberIII {
    //only 2 cases possible: [robbingRoot, withoutRobbingRoot]
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0],res[1]);
    }

    public int[] dfs(TreeNode root) {//return [withRoot, withoutRoot]
        if(root == null) {
            return new int[]{0,0};
        }
        int[] leftPair = dfs(root.left);
        int[] rightPair = dfs(root.right);
        return new int[]{root.val+leftPair[1]+rightPair[1], Arrays.stream(leftPair).max().getAsInt()+Arrays.stream(rightPair).max().getAsInt()};
    }
}
