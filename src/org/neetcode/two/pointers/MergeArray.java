package org.neetcode.two.pointers;

public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int last = m+n-1;
        while(m > 0 && n > 0) {
            if(nums1[m-1] > nums2[n-1]) {
                nums1[last] = nums1[m-1];
                m--;
            } else {
                nums1[last] = nums2[n-1];
                n--;
            }
            last--;
        }
        while(n > 0) {
            nums1[last] = nums2[n-1];
            last--;
            n--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;
        MergeArray mergeArray = new MergeArray();
        mergeArray.merge(nums1,m,nums2,n);
    }
}
