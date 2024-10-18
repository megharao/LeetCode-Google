package org.neetcode.stacks;

import java.util.Stack;

public class RemoveAllAdjDupInStr {
    public String removeDuplicates(String s, int k) {
        Stack<String> stack = new Stack<>();
        int count = 0;
        for(char c: s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek().toString().split("#")[0].equals(String.valueOf(c))) {
                count = Integer.parseInt(stack.peek().toString().split("#")[1]);
                count++;
            } else {
                count = 1;
            }
            stack.push(c+"#"+count);
            if(count == k) {
                while (!stack.isEmpty() && count > 0) {
                    stack.pop();
                    count--;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop().split("#")[0]);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveAllAdjDupInStr removeAllAdjDupInStr = new RemoveAllAdjDupInStr();
        System.out.println(removeAllAdjDupInStr.removeDuplicates("pbbcggttciiippooaais",2));
    }
}
