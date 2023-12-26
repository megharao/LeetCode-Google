package org.neetcode.arrays.hashing;

public class NextGreaterEleI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    for(int k = j+1; k < nums2.length; k++ ) {
                        if(nums2[k] > nums2[j]) {
                            res[i] = nums2[k];
                            break;
                        }
                    }
                    if(res[i] == 0) {
                        res[i] = -1;
                        break;
                    }
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4}, nums2 = {1,2,3,4};
        NextGreaterEleI nextGreaterEleI = new NextGreaterEleI();
        System.out.println(nextGreaterEleI.nextGreaterElement(nums1,nums2));
    }
}
