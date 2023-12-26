package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxProdOfTwoPaliSubseq {
    public int maxProduct(String s) {
        int N = s.length();
        Map<Integer, Integer> pali = new HashMap<>();
        for(int mask = 1; mask < (1 << N); mask++) { // 1 << N = 2^N
            String subseq = "";
            for(int i = 0; i < N; i++) {
                if((mask & (1 << i)) != 0) {
                    subseq += s.charAt(i);
                }
            }
            if(subseq.equals(new StringBuilder(subseq).reverse().toString())) {
                pali.put(mask, subseq.length());
            }
        }
        int res = 0;
        for(int m1: pali.keySet()) {
            for(int m2: pali.keySet()) {
                if((m1 & m2) == 0) { // disjoint
                    res = Math.max(res, pali.get(m1)*pali.get(m2));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxProdOfTwoPaliSubseq maxProdOfTwoPaliSubseq = new MaxProdOfTwoPaliSubseq();
        System.out.println(maxProdOfTwoPaliSubseq.maxProduct("leetcodecom"));
    }
}
