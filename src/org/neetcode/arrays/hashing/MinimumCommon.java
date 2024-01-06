package org.neetcode.arrays.hashing;

public class MinimumCommon {
    public static int getCommon(int[] nums1, int[] nums2) {
        int min = -1;
        int i1 = 0, i2 = 0;
        while(i1 < nums1.length && i2 < nums2.length ) {
            if(nums1[i1] == nums2[i2]) {
                return nums1[i1];
            } else if(nums1[i1] < nums2[i2]) {
                i1++;
            } else {
                i2++;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,6};
        int[] nums2 = {2,3,4,5};
        System.out.print(getCommon(nums1, nums2));
    }
}
