package org.neetcode.arrays.hashing;

import java.util.*;
import java.util.stream.IntStream;

public class Intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] res = new int[Math.max(nums1.length, nums2.length)];
        int i = 0, j=0, k=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i < l1 && j < l2) {
            if(nums1[i] < nums2[j]) {
                i++;
            } else if(nums1[i] > nums2[j]) {
                j++;
            } else {
                res[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(res, 0, k);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] res = intersection(nums1,nums2);
        for(int i: res) {
            System.out.print(i + " ");
        }
    }
}
