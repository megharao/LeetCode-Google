package org.neetcode.two.pointers;

import java.util.Arrays;

public class RearrangeArrElemBySign {
    public static int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int[] pos = new int[nums.length/2];
        int posI = 0;
        int[] neg = new int[nums.length/2];
        int negI = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= 0) {
                pos[posI++] = nums[i];
            } else {
                neg[negI++] = nums[i];
            }
        }
        posI = 0;
        negI = 0;
        for(int i = 0; i < res.length; i++) {
            if(i%2 == 0) {
                res[i] = pos[posI++];
            } else {
                res[i] = neg[negI++];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1};
        int[] res = rearrangeArray(nums);
        Arrays.stream(res).forEach(System.out::println);
    }
}
