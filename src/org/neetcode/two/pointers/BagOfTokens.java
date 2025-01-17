package org.neetcode.two.pointers;

import java.util.Arrays;

public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        //smallest token face up and biggest token face down to increase power
        int res = 0, score = 0;
        Arrays.sort(tokens);
        int left = 0, right = tokens.length-1;
        while(left <= right) {
            if(power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
                res = Math.max(res, score);
            } else if(score > 0) {
                power += tokens[right];
                right--;
                score--;
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
