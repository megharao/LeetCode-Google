package org.neetcode.arrays.hashing;

import java.util.Arrays;

public class LargestPerimeterPolygon {
    public static long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long res = -1;
        long total = 0;
        for(int n : nums) {
            if(total > n) {
                res = total + n;
            }
            total += n;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
