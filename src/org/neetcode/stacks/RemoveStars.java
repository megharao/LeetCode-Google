package org.neetcode.stacks;

import java.util.Optional;
import java.util.Stack;

public class RemoveStars {
    public String removeStars(String s) {
        Stack<String> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c!='*') {
                stack.push(String.valueOf(c));
            } else {
                stack.pop();
            }
        }
        Optional<String> optional = stack.stream().reduce(String::concat);
        return optional.isPresent() ? optional.get() : "";
    }

    public static void main(String[] args) {
        String s = "erase*****";
        RemoveStars removeStars = new RemoveStars();
        System.out.println(removeStars.removeStars(s));
    }
}
