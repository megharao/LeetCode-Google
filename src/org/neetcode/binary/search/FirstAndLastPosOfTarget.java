package org.neetcode.binary.search;

public class FirstAndLastPosOfTarget {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = binarySearch(nums,target,true);
        res[1] = binarySearch(nums,target,false);
        return res;
    }

    public int binarySearch(int[] nums, int target, boolean leftBias) {
        int l = 0, r= nums.length-1;
        int i = -1;
        while(l <= r) {
            int m = l+(r-l)/2;
            if(target > nums[m]) {
                l=m+1;
            } else if(target < nums[m]){
                r = m-1;
            } else {
                i = m;
                if(leftBias) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            }
        }
        return  i;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
    }
}
