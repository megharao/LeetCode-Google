package org.neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        backtrack(1,new ArrayList<>(),n,k);
        return res;
    }

    public void backtrack(int start, List<Integer> comb, int n, int k) {
        if(comb.size() == k) {
            res.add(comb);
            return;
        }
        for(int i = start; i <= n; i++) {
            comb.add(i);
            backtrack(i+1,comb,n,k);
            comb.remove((Integer) i);
        }

    }
}
