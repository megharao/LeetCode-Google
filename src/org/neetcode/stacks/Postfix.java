package org.neetcode.stacks;

import java.util.Stack;

public class Postfix {
    public static int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> token = new Stack<>();
        for (String t: tokens) {
            if(t.matches("-?[0-9]+")) {
                token.push(Integer.valueOf(t));
            } else {
                int rVal = token.pop();
                int lVal = token.pop();
                res = eval(lVal, rVal, t);
                token.push(res);
            }
        }
        return res;
    }

    public static int eval(int l, int r, String op) {
        switch (op) {
            case "+": return l+r;
            case "-": return l-r;
            case "*": return l*r;
            case "/": return l/r;
        }
        return 0;
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
