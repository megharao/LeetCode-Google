package org.neetcode.stacks;

import java.util.Stack;
import java.util.stream.Collectors;

public class GreatString {
    public static String makeGood(String s) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if(!stack.isEmpty()
                    && !stack.peek().equals(String.valueOf(s.charAt(i)))
            && stack.peek().toLowerCase().equals(String.valueOf(s.charAt(i)).toLowerCase())) {
                stack.pop();
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
            i++;
        }
        return stack.stream() // Create a stream from the stack
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),  // Collect elements into a list
                        list -> String.join("", list)
                ));
    }

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }
}
