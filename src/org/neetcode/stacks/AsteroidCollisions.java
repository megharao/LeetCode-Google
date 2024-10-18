package org.neetcode.stacks;

import java.util.Stack;
import java.util.stream.Collectors;

public class AsteroidCollisions {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < asteroids.length) {
            int a = asteroids[i];
            if(stack.isEmpty()) {
                stack.push(a);
                i++;
            } else {
                if((stack.peek() > 0 && asteroids[i] > 0) || (stack.peek() <0 && asteroids[i] < 0)) {
                    stack.push(asteroids[i]);
                    i++;
                } else {
                    if(Math.abs(stack.peek()) > Math.abs(a)) {
                        i++;
                    } else if(Math.abs(stack.peek()) < Math.abs(a)) {
                        stack.pop();
                    } else {
                        i++;
                        stack.pop();
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        int j = 0;
        while(!stack.isEmpty()) {
            res[j] = stack.pop();
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] asteroids = {10,2,-5};
        AsteroidCollisions asteroidCollisions = new AsteroidCollisions();
        System.out.println(asteroidCollisions.asteroidCollision(asteroids));
    }
}
