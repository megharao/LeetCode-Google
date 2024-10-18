package org.neetcode.one.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BestTimeWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        List<int[]> pairs = new ArrayList<>();
        for(int i = 0; i < scores.length; i++) {
            int[] pair = new int[2];
            pair[0] = scores[i];
            pair[1] = ages[i];
            pairs.add(pair);
        }
        pairs.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        }); //sort based on score asc order
//        return dfs(0,1,pairs);
        int[] dp = new int[scores.length];
        for(int i = 0; i < scores.length; i++) {
            dp[i] = pairs.get(i)[0];
        }
        for(int i = 0; i < pairs.size(); i++) {
            int maxScore = pairs.get(i)[0], maxAge = pairs.get(i)[1];
            for(int j= 0;  j < i; j++) {
                int score = pairs.get(j)[0], age = pairs.get(j)[1];
                if(maxAge >= age) {
                    dp[i] = Math.max(dp[i],maxScore+dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
