package org.neetcode.arrays.hashing;

public class MinSwaps {
    public int minSwaps(String s) {
        int max = 0;
        int extraClose = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
                extraClose++;
            }
            if(s.charAt(i) == '[') {
                extraClose--;
            }
            max = Math.max(max,extraClose);
        }
        return (max+1)/2;
    }

    public static void main(String[] args) {

    }
}
