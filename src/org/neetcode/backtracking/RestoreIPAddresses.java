package org.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if(s.length() > 12) {
            return res;
        }
        backtrack(res,0,s,0,"");
        return res;
    }

    public void backtrack(List<String> res, int i, String s, int dots, String currIP) {
        if(dots==4 && i == s.length()){
            res.add(currIP.substring(0,currIP.length()-1));
            return;
        }
        if(dots > 4 ) {
            return;
        }
        for(int j = i; j < Math.min(i+3,s.length()); j++) {
            if(Integer.valueOf(s.substring(i,j+1)) < 256 && (i==j || s.charAt(i) != '0')) {
                backtrack(res,j+1,s, dots+1,currIP+s.substring(i,j+1)+".");
            }
        }
    }
}
