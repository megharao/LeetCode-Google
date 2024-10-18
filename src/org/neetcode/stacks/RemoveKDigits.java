package org.neetcode.stacks;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k==num.length() || k>num.length()){
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        char[] ch = num.toCharArray();
        for(char c: ch) {
            while(k >0 && !stack.isEmpty() && stack.peek() > c) {
                k--;
                stack.pop();
            }
            stack.add(c);
        }
        while(!stack.isEmpty() && k >0) {
            stack.pop();
            k--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        stringBuilder.reverse();
        while(stringBuilder.length() > 1 && stringBuilder.charAt(0) == '0') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {

    }
}
