package org.neetcode.one.dynamic.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UncrossedLines {
    Map<String, Integer> dp = new HashMap<>();
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
//        return dfs(0,0,nums1,nums2);
        int[] dp = new int[nums2.length+1];
        Arrays.fill(dp,0);
        for(int i = 0; i < nums1.length; i++) {
            int[] newdp = new int[nums2.length+1];
            Arrays.fill(newdp,0);
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    newdp[j+1] = 1 + dp[j];
                } else {
                    newdp[j+1] = Math.max(dp[j+1], newdp[j]);
                }
            }
            dp = newdp;
        }
        return dp[nums2.length];
    }

    public static void main(String[] args) {
        int[] nums1 = {1,4,2};
        int[] nums2 = {1,2,4};
        UncrossedLines uncrossedLines = new UncrossedLines();
        uncrossedLines.maxUncrossedLines(nums1,nums2);
    }

    public int dfs(int i, int j, int[] nums1, int[] nums2) {
        if(i==nums1.length || j == nums2.length) {
            return 0;
        }
        if(dp.containsKey(i+"#"+j)) {
            return dp.get(i+"#"+j);
        }
        if(nums1[i] == nums2[j]) {
             int res = 1 + dfs(i+1, j+1, nums1, nums2);
             dp.put(i+"#"+j,res);
        } else {
            int res = Math.max(dfs(i+1,j,nums1,nums2),dfs(i,j+1,nums1,nums2));
            dp.put(i+"#"+j, res);
        }
        return dp.get(i+"#"+j);
    }
}
