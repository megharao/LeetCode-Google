package org.neetcode.backtracking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MatchSticksToSquare {
    public boolean makesquare(int[] matchsticks) {
        int sum = Arrays.stream(matchsticks).sum();
        if(sum%4!=0) {
            return false;
        }
        int target = sum/4;
        int[] sides = new int[4];
        List<Integer> sortedMatchsticks = Arrays.stream(matchsticks).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());//to get largest match stick first and see if it is > target
        return backtrack(0,matchsticks,sides,target);
    }

    public boolean backtrack(int i, int[] matchsticks, int[] sides, int target) {
        if(i==matchsticks.length) {
            return true;
        }
        for(int j = 0; j < 4; j++) {
            if(sides[j] + matchsticks[i] <= target) {
                sides[j] += matchsticks[i];
                if(backtrack(i+1,matchsticks,sides,target)) {
                    return true;
                }
                sides[j]-= matchsticks[i];
            }
        }
        return false;
    }



    public static void main(String[] args) {
        int[] matchsticks = {1,1,2,2,2};
        MatchSticksToSquare matchSticksToSquare = new MatchSticksToSquare();
        matchSticksToSquare.makesquare(matchsticks);
    }
}
