package org.neetcode.one.dynamic.programming;

public class Tribbonacci {
    public int tribonacci(int n) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        for(int i = 3; i<=n; i++) {
            int temp = t0+t1+t2;
            t0 = t1;
            t1 = t2;
            t2 = temp;
        }
        return t2;
    }

    public static void main(String[] args) {
        Tribbonacci tribbonacci = new Tribbonacci();
        System.out.println(tribbonacci.tribonacci(25));
    }
}
