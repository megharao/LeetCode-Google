package org.neetcode.arrays.hashing;

public class MinChangeAlterStr {

    public static int minOperations(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            if(i%2 == 1) {
                if(s.charAt(i) == 0) res++;
            } else {
                if(s.charAt(i) == 1) res++;
            }
        }
        return Math.min(res, s.length()-res);
    }
    public static void main(String[] args) {
        String s = "0100";
        System.out.println(minOperations(s));
    }
}
