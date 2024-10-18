package org.neetcode.stacks;

import java.util.Stack;

public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < operations.length; i++) {
            String s = operations[i];
            if(s.equals("C")) {
                stack.pop();
            } else if(s.equals("D")) {
                stack.push(stack.peek()*2);
            } else if(s.equals("+")) {
                int elem1 = stack.pop();
                int elem2 = stack.peek();
                stack.push(elem1);
                stack.push(elem1+elem2);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        int score = 0;
        while(!stack.isEmpty()) {
            score += stack.pop();
        }
        return score;
    }

    public static void main(String[] args) {
        String[] operations = {"1","C"};
        BaseballGame baseballGame = new BaseballGame();
        System.out.println(baseballGame.calPoints(operations));
    }
}
