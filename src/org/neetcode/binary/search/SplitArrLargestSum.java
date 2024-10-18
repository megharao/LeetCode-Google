package org.neetcode.binary.search;

import java.util.Arrays;

public class SplitArrLargestSum {
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).max().getAsInt();
        int r = Arrays.stream(nums).sum();
        int res = r;
        while(l <= r) {
            int m = l + (r-l)/2;
            if(canSplit(m, nums, k)) {
                res = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return res;
    }

    public boolean canSplit(int m, int[] nums, int k) {
        int subArray = 0, currSum = 0;
        for(int n:nums) {
            currSum+=n;
            if(currSum>m) {
                subArray++;
                currSum = n;
            }
        }
        return subArray +1 <= k;
    }

    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        SplitArrLargestSum splitArrLargestSum = new SplitArrLargestSum();
        System.out.println(splitArrLargestSum.splitArray(nums,2));
    }
}
