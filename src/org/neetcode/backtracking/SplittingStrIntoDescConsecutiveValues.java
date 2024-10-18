package org.neetcode.backtracking;

public class SplittingStrIntoDescConsecutiveValues {
    public boolean splitString(String s) {
        for(int i = 0; i < s.length()-1; i++) {
            double value = Double.valueOf(s.substring(0,i+1));
            if(backtrack(i+1,value,s)) {
                return true;
            }
        }
        return false;
    }

    public boolean backtrack(int i, double prev, String s) {
        if(i==s.length()) {
            return true;
        }
        for(int j = i; j < s.length(); j++) {
            double val = Double.valueOf(s.substring(i,j+1));
            if(prev-val==1 && backtrack(j+1,val,s)) {
                return true;
            }
        }
        return false;
    }
}
