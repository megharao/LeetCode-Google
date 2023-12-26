package org.neetcode.bit.manipulation;

public class CountBits {
    public int[] countBits(int n) {
        int[] res = new int[n+1];
        res[0] = 0;
        int pow2 = 1;
        for(int i = 1; i <= n; i++) {
            if(pow2 * 2 == i) {
                pow2 = i;
            }
            res[i] = 1 + res[i-pow2];
        }
        return res;
    }

    public static void main(String[] args) {
        CountBits countBits = new CountBits();
        System.out.println(countBits.countBits(5));
    }
}
