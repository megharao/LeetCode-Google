package org.neetcode.graph;

public class CheckIfMoveIsLegal {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1},
                {1,1},{-1,-1},{1,-1},{-1,1}};
        board[rMove][cMove] = color;
        for(int[] d: direction) {
            if(legal(board, rMove, cMove, color, d)) {
                return true;
            }
        }
        return false;
    }

    public boolean legal(char[][] board, int rMove, int cMove, char color, int[] d ){
        int rows = board.length, cols = board[0].length;
        int dr = d[0], dc = d[1];
        rMove += dr;
        cMove += dc;
        int len = 1;
        while(rMove >= 0 && rMove < rows && cMove >= 0 && cMove < cols) {
            len++;
            if(board[rMove][cMove] == '.') {
                return false;
            }
            if(board[rMove][cMove] == color) {
                return len >= 3;
            }
            rMove += dr;
            cMove += dc;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
