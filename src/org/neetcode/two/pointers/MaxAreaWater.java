package org.neetcode.two.pointers;

public class MaxAreaWater {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length-1;
        while(l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }
}
