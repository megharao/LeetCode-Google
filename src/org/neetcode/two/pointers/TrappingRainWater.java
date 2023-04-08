package org.neetcode.two.pointers;

public class TrappingRainWater {
    public static int trap(int[] height) {
        int water = 0;
        int i = 0, j = height.length-1;
        int maxLeft = height[i], maxRight = height[j];
        while(i < j) {
            if(maxLeft <= maxRight) {
                i++;
                maxLeft = Math.max(maxLeft, height[i]);
                water += maxLeft - height[i];
            } else {
                j--;
                maxRight = Math.max(maxRight, height[j]);
                water += maxRight - height[j];
            }
        }

        return water;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }
}
