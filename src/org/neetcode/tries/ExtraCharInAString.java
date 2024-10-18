package org.neetcode.tries;

import java.util.*;

public class ExtraCharInAString {
    Integer[] dp; int n; String str; HashSet<String> set;
    public int minExtraChar(String s, String[] dictionary) {
        n=s.length(); dp=new Integer[n+1]; dp[n]=0;
        str=s; set=new HashSet<String>(Arrays.asList(dictionary));
        return f(0);
    }

    private int f(int ind) {
        if(dp[ind]!=null) return dp[ind];
        int cnt_min_extra=Integer.MAX_VALUE;
        for(int i=ind; i<n; ++i) {
            int extraChars = f(i+1) + (set.contains(str.substring(ind, i+1))?0: i-ind+1);
            cnt_min_extra=Math.min(cnt_min_extra, extraChars);
        }
        return dp[ind]=cnt_min_extra;
    }
}
