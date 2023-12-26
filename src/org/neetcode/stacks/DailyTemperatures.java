package org.neetcode.stacks;

import java.util.Stack;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> prev = new Stack<>();
        for(int i=0; i < temperatures.length; i++) {
            while(!prev.isEmpty() && temperatures[prev.peek()] < temperatures[i]) {
                int prevDay = prev.pop();
                ans[prevDay] = i-prevDay;
            }
            prev.push(i);
            }
        return ans;
    }

    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};
        int[] ans = dailyTemperatures(temp);
        for(int i : ans) {
            System.out.print(i+ " ");
        }
    }
}
