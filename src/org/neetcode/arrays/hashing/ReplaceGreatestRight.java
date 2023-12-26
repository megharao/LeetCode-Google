package org.neetcode.arrays.hashing;

import java.util.Map;

public class ReplaceGreatestRight {
    public int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        int greatest = -1;
        for(int i = ans.length-1; i >=0; i--) {
            ans[i] = greatest;
            greatest = Math.max(greatest,arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {17,18,5,4,6,1};
        ReplaceGreatestRight replaceGreatestRight = new ReplaceGreatestRight();
        System.out.println(replaceGreatestRight.replaceElements(nums));
    }
}
