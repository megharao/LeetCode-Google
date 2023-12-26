package org.neetcode.two.dynamic.programming;

public class RegularExpressionMatching {

    String s;
    String p;
    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        return dfs(0,0);
    }

    public boolean dfs(int i, int j) {
        if(i >= s.length() && j >= p.length()) {
            return true;
        }
        if(j >= p.length()) {
            return false;
        }
        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return dfs(i,j+2) //don't use *
                    || (match && dfs(i+1,j)); //use *
        }
        if(match) {
            return dfs(i+1,j+1);
        }
        return false;
    }
}
