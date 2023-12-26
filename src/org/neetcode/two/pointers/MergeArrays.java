package org.neetcode.two.pointers;

public class MergeArrays {
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int len = nums1.length + nums2.length;
        int[][] result = new int[len][2];
        int k = 0, i = 0, j = 0;
        while( i <= nums1.length-1 && j <= nums2.length-1) {
                int[] nums1i = nums1[i];
                int[] nums2j = nums2[j];
                if(nums1i[0] == nums2j[0]) {
                    result[k] = new int[] {nums1i[0], nums1i[1]+nums2j[1] };
                    k++;
                    i++;
                    j++;
                } else if(nums1i[0] < nums2j[0]) {
                    result[k] = new int[] {nums1i[0], nums1i[1]};
                    k++;
                    i++;
                } else {
                    result[k] = new int[] {nums2j[0], nums2j[1]};
                    k++;
                    j++;
                }
        }
        while(i <= nums1.length-1) {
            result[k++] = nums1[i++];
        }
        while(j <= nums2.length-1) {
            result[k++] = nums2[j++];
        }
        int[][] finalRes = new int[k][2];
        System.arraycopy(result, 0, finalRes, 0, k);
        return finalRes;
    }

    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        int[][] result = mergeArrays(nums1,nums2);
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
