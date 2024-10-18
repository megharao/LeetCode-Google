package org.neetcode.arrays.hashing;

import java.util.*;

public class SequentialDigits {
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= 9; i++) {
            queue.add(i);
        }
        while(!queue.isEmpty()) {
            int n = queue.poll();
            if(n > high) {
                continue;
            }
            if(n >= low && n <= high) {
                res.add(n);
            }
            int ones = n % 10;
            if( ones < 9) {
                queue.add(n * 10 + (ones+1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int low = 1000, high = 13000;
        System.out.println(sequentialDigits(low, high));
    }
}
