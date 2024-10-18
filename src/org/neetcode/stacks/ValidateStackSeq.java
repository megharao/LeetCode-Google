package org.neetcode.stacks;

import java.util.Stack;

public class ValidateStackSeq {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        int i = 0, j = 0;
        while(i < pushed.length) {
            if(pushed[i] == popped[j]) {
                i++;
                j++;
            } else {
                while(!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
                stack.push(pushed[i]);
                i++;
            }
        }
        while(!stack.isEmpty()) {
            if(stack.pop() != popped[j]) {
                return false;
            }
            j++;
        }
        return flag;
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,3,5,1,2};
        ValidateStackSeq validateStackSeq = new ValidateStackSeq();
        System.out.println(validateStackSeq.validateStackSequences(pushed,popped));
    }
}
