package org.neetcode.stacks;

import java.util.Stack;

public class LargestRecInHisto {

    class StackIndex {
        int height;
        int index;

        StackIndex(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int index = -1;
        Stack<StackIndex> stack = new Stack<>();
        for(int i = 0; i < heights.length;i++) {
            index = i;
            while (!stack.isEmpty() && stack.peek().height > heights[i]) {
                maxArea = Math.max(maxArea, stack.peek().height*(i-stack.peek().index));
                index = stack.peek().index;
                stack.pop();

            }
            stack.push(new StackIndex(heights[i],index));
            maxArea = Math.max(maxArea, heights[i]*1);
        }
        while(!stack.isEmpty()) {
            maxArea = Math.max(maxArea, stack.peek().height*(heights.length-stack.peek().index));
            stack.pop();
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1,1};
        LargestRecInHisto l = new LargestRecInHisto();
        System.out.println(l.largestRectangleArea(heights));
    }
}
