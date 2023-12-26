package org.neetcode.graph;

import java.util.HashSet;
import java.util.Set;

public class MaxArea {
    Set<String> visited = new HashSet<>();
    int rows;
    int cols;
    public int maxAreaOfIsland(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j]==1) {
                    maxArea = Math.max(maxArea, dfs(i,j,grid));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int r, int c, int[][] grid) {
        if(r < 0 || r >= rows || c < 0 || c >= cols
        || visited.contains(r+"#"+c) || grid[r][c]==0) {
            return 0;
        }
        visited.add(r+"#"+c);
        return 1 + dfs(r+1,c, grid) +
                dfs(r-1,c, grid) +
                dfs(r,c+1, grid) +
                dfs(r,c-1, grid);
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxAreaOfIsland(grid));
    }
}
