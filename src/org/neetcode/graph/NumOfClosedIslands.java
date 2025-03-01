package org.neetcode.graph;

public class NumOfClosedIslands {

    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    boolean[][] visit;
    int ROWS, COLS;
    public int closedIsland(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visit = new boolean[ROWS][COLS];
        int res = 0;
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < ROWS; j++) {
                if(grid[i][j] == 0 && !visit[i][j]) {
                    if(dfs(grid,i,j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public boolean dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i == ROWS || j == COLS) {
            return false;
        }
        if(grid[i][j] == 1 || visit[i][j]) {
            return true;
        }
        visit[i][j] = true;
        boolean res = true;
        for(int[] d: dir) {
            if(!dfs(grid, i+d[0], j + d[1])) {
                res = false;
            }
        }
        return res;
    }
}
