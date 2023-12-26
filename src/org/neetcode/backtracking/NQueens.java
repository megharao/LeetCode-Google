package org.neetcode.backtracking;

import java.util.*;

public class NQueens {
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDia = new HashSet<>(); //r+c
    Set<Integer> negDia = new HashSet<>(); //r-c
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList();
        char [][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        dfs(0,n, board, res);
        return res;
    }

    public void dfs(int r, int n, char[][] board, List<List<String>> res) {
        if(r == n) {
            res.add(construct(board));
            return;
        }
        for(int c = 0; c < n; c++) {
            if(cols.contains(c) || posDia.contains(r+c) || negDia.contains(r-c)) {
                continue;
            }
            cols.add(c);
            posDia.add(r+c);
            negDia.add(r-c);
            board[r][c] = 'Q';
            dfs(r+1, n, board, res);
            cols.remove(Integer.valueOf(c));
            posDia.remove(Integer.valueOf(r+c));
            negDia.remove(Integer.valueOf(r-c));
            board[r][c] = '.';
        }
    }

     public List<String> construct(char[][] board) {
         List<String> internal = new ArrayList<>();
         for (int i = 0; i < board.length; i++) {
             String row = new String(board[i]);
             internal.add(row);
         }
         return internal;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> res = nQueens.solveNQueens(4);
        for(List<String> r: res) {
            r.stream().forEach(i->System.out.println(i+" "));
            System.out.println();
        }
    }

}
