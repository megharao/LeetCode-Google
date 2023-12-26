package org.neetcode.graph;

public class SurroundedRegion {
    int rows;
    int cols;
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        //capture unsurrounded regions dfs
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(board[r][c] == 'O' && ((r == 0 || r == rows-1)
                        || (c == 0 || c == cols-1))) {
                    dfs(r,c,board);
                }
            }
        }

        //capture surrounded regions
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        //uncapture unsurrounded regions
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int r, int c, char[][] board) {
        if(r < 0 || r >= rows || c <0 || c >= cols || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'T';
        dfs(r+1,c,board);
        dfs(r-1,c,board);
        dfs(r,c+1,board);
        dfs(r,c-1,board);
    }

    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        SurroundedRegion surroundedRegion = new SurroundedRegion();
        surroundedRegion.solve(board);
        for(char[] bo: board){
            for (char b: bo) {
                System.out.print(b+ " ");
            }
            System.out.println();
        }
    }
}
