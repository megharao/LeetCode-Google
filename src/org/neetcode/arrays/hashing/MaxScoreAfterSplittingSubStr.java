package org.neetcode.arrays.hashing;

public class MaxScoreAfterSplittingSubStr {
    public static int maxScore(String s) {
        int zero = 0;
        int one = 0;
        int maxScore = 0;
        for(int i = 0; i <s.length(); i++) {
            if(s.charAt(i) == '1') {
                one++;
            }
        }

        for(int i = 0; i < s.length()-1; i++) {
            if(s.charAt(i) == '0') {
                zero++;
            } else if(s.charAt(i) == '1') {
                one--;
            }
            maxScore = Math.max(maxScore, zero+one);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        String s = "00";
        System.out.println(maxScore(s));
    }
}
