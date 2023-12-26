package org.neetcode.backtracking;

import java.util.HashSet;
import java.util.Set;

public class Word {
    boolean flag = false;
    Set<String> visited = new HashSet<>();
    int ROW = 0;
    int COL = 0;
    public boolean exist(char[][] board, String word) {
        ROW = board.length;
        COL = board[0].length;
        for(int i = 0; i < ROW; i++) {
            for(int j = 0; j < COL; j++) {
                dfs(i,j,0,word,board);
            }
        }
        return flag;
    }

    public void dfs(int i, int j, int index, String word, char[][] board) {
        if(i < 0 || j < 0 || i >= ROW || j >= COL) {
            return;
        }
        if(visited.contains(i+"#"+j) || board[i][j]!=word.charAt(index)) {
            return;
        }

        visited.add(i+"#"+j);
        index++;
        if(index == word.length()) {
            flag = true;
            return;
        }
        dfs(i-1, j, index, word, board);
        dfs(i+1, j, index, word, board);
        dfs(i, j-1, index, word, board);
        dfs(i, j+1, index, word, board);
    }
    public static void main(String[] args) {
        Word w = new Word();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(w.exist(board,"ABCCED"));
    }
}
