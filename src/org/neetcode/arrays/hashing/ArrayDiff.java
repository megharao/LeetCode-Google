package org.neetcode.arrays.hashing;

import java.util.*;

public class ArrayDiff {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>(2);
        Set<Integer> list1 = new HashSet<>();
        Set<Integer> list2 = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int prev = 1001;
        while(i < nums1.length && j < nums2.length) {
            if(nums1[i] == prev) {
                i++;
                continue;
            }
            if(nums2[j] == prev) {
                j++;
                continue;
            }
            if(nums1[i] == nums2[j]) {
                prev = nums1[i];
                i++;
                j++;
            } else {
                if(nums1[i] < nums2[j]) {
                    list1.add(nums1[i]);
                    i++;
                } else {
                    list2.add(nums2[j]);
                    j++;
                }
            }
        }
        while(i < nums1.length) {
            if(prev != nums1[i]) {
                list1.add(nums1[i]);
            }
            i++;
        }
        while(j < nums2.length) {
            if(prev != nums2[j]) {
                list2.add(nums2[j]);
            }
            j++;
        }
        res.add(list1.stream().toList());
        res.add(list2.stream().toList());
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {-3,6,-5,4,5,5}, nums2 = {6,6,-3,-3,3,5};
        ArrayDiff arrayDiff = new ArrayDiff();
        System.out.println(arrayDiff.findDifference(nums1,nums2));
    }
}
