package org.neetcode.stacks;

import java.util.Stack;

public class ValidParantheses {
    public static boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            String sc = String.valueOf(c);
            switch(sc) {
                case "(":
                case "{":
                case "[":
                    stack.push(sc);
                    break;
                case ")":
                case "}":
                case "]":
                    if(!stack.isEmpty()){
                        String pop = stack.pop();
                        if (!pop.equals(getOpenBracket(sc))) {
                            return false;
                        }
                    } else {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static String getOpenBracket(String s) {
        if(s.equals(")"))
            return "(";
        if(s.equals("}"))
            return "{";
        if (s.equals("]"))
            return "[";
        return "";
    }

    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValid(s));
    }
}
