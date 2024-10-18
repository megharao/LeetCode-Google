package org.neetcode.one.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class SolveQuestionsWithBrainPower {

    Map<Integer, Integer> dp;
    public long mostPoints(int[][] questions) {
        dp = new HashMap<>();
        for(int i = questions.length-1; i >= 0; i--) {
            int value = Math.max(questions[i][0]+dp.getOrDefault(i+1+questions[i][1],0), //include current question
                    dp.getOrDefault(i+1,0));
            dp.put(i,value);
        }
//        return dfs(questions,0);
        return dp.get(0);
    }

    public int dfs(int[][] questions, int i) {
        if(i >= questions.length) {
            return 0;
        }
        if(dp.containsKey(i)) {
            return dp.get(i);
        }
        int score = questions[i][0];
        int res = Math.max(dfs(questions, i+1),//skip current question
                score + dfs(questions,i+1+questions[i][1])); //solve current question and skip next i+1+brainpower as 0 indexed
        dp.put(i,res);
        return res;
    }
}
