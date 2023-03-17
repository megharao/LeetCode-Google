package org.neetcode.arrays.hashing;

import java.util.*;

/**
 * Determine if a 9 x 9 org.neetcode.arrays.hashing.Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 */
public class Sudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String>seen=new HashSet<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char cur= board[i][j];
                if(cur != '.'){
                    if(!seen.add(cur+"row"+i)||!seen.add(cur+"col"+j)||!seen.add(cur+"grid"+i/3+"-"+j/3)){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'.','.','.','.','5','.','.','1','.'},
                 {'.','4','.','3','.','.','.','.','.'},
                 {'.','.','.','.','.','3','.','.','1'},
                 {'8','.','.','.','.','.','.','2','.'},
                 {'.','.','2','.','7','.','.','.','.'},
                 {'.','1','5','.','.','.','.','.','.'},
                 {'.','.','.','.','.','2','.','.','.'},
                 {'.','2','.','9','.','.','.','.','.'},
                 {'.','.','4','.','.','.','.','.','.'}};

        System.out.println(new Sudoku().isValidSudoku(board));
    }
}
