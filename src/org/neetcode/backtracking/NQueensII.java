package org.neetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class NQueensII {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDia = new HashSet<>();
    Set<Integer> negDia = new HashSet<>();
    int res;
    public int totalNQueens(int n) {
        res = 0;
        dfs(0, n);
        return res;
    }

    public void dfs(int row, int n) {
        if(row==n) {
            res++;
            return;
        }
        for(int c = 0; c < n; c++) {
            if(cols.contains(c) || posDia.contains(row+c) || negDia.contains(row-c)) {
                continue;
            }
            cols.add(c);
            posDia.add(row+c);
            negDia.add(row-c);
            dfs(row+1, n);
            cols.remove(c);
            posDia.remove(row+c);
            negDia.remove(row-c);
        }
    }

    public static void main(String[] args) {

    }
}
