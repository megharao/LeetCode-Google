package org.neetcode.two.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences {

    Map<String, Integer> dp = new HashMap<>();
    String s;
    String t;
    public int numDistinct(String s, String t) {
        this.s = s;
        this.t = t;
        return dfs(0,0);
    }

    public int dfs(int i, int j) {
        if(j == t.length())
            return 1;
        if(i == s.length())
            return 0;
        if(dp.containsKey(i+"#"+j)) {
            return dp.get(i+"#"+j);
        }
        if(s.charAt(i)==t.charAt(j))
            dp.put(i+"#"+j,dfs(i+1,j+1) + dfs(i+i,j));
        else
            dp.put(i+"#"+j,dfs(i+i,j));
        return dp.get(i+"#"+j);
    }

    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        DistinctSubsequences distinctSubsequences = new DistinctSubsequences();
        System.out.println(distinctSubsequences.numDistinct(s,t));
    }
}
