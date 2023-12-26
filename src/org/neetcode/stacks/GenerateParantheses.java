package org.neetcode.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParantheses {
    public static List<String> generateParenthesis(int n) {
        /**
         * only add open parantheses if open < n
         * only add closing parantheses if close<open
         * valid if open = close = n
         */
        List<String> parantheses = new ArrayList<>();
        backtrack(parantheses, "", 0, 0, n);
        return parantheses;
    }

    public static void backtrack(List<String> parantheses, String para, int openCount, int closeCount, int n) {
        if(para.length()==n*2) {
            parantheses.add(para);
            return;
        }
        if(openCount < n) {
            backtrack(parantheses, para+"(", openCount+1, closeCount, n);
        }
        if(closeCount < openCount) {
            backtrack(parantheses, para+")", openCount, closeCount+1, n);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
