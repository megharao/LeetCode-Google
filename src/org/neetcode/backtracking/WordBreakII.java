package org.neetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

    Set<String> wordDict;
    List<String> res;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        dfs(s,0,curr);
        return res;
    }

    public void dfs(String s, int i, List<String> curr) {
        if(i==s.length()) {
            res.add(String.join(" ", curr));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            String subStr = s.substring(i, j+1);
            if(wordDict.contains(subStr)) {
                curr.add(subStr);
                dfs(s,j+1,curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
