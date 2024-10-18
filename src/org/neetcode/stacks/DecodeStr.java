package org.neetcode.stacks;

import java.util.Stack;

public class DecodeStr {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if(!str.equals("]")) {
                stack.push(str);
            } else {
                String substr = "";
                while(!stack.peek().equals("[")) {
                    substr = stack.pop() + substr;
                }
                stack.pop();
                String k = "";
                while(!stack.isEmpty() && stack.peek().matches("[0-9]")) {
                    k = stack.pop() + k;
                }
                for(int j = 0; j < Integer.parseInt(k); j++) {
                    stack.push(substr);
                }
            }
        }
        String res = "";
        while(!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        DecodeStr decodeStr = new DecodeStr();
        System.out.println(decodeStr.decodeString(s));
    }
}
