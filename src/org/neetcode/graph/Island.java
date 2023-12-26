package org.neetcode.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Island {
    int rows = 0;
    int cols = 0;
    public int numIslands(char[][] grid) {
        if(grid.length == 0) {
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        Set<String> visited = new HashSet<>();
        int islands = 0;
        for(int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if(grid[r][c] == '1' && !visited.contains(r+"#"+c)) {
                    islands++;
                    bfs(r,c, visited, grid);
                }
            }
        }
        return islands;
    }

    public void bfs(int r, int c, Set<String> visited, char[][] grid) {
        Queue<String> q = new ArrayDeque<>();
        visited.add(r+"#"+c);
        q.add(r+"#"+c);
        while(!q.isEmpty()) {
            String[] rc = q.poll().split("#");
            int row = Integer.parseInt(rc[0]);
            int col = Integer.parseInt(rc[1]);
            int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] dir: directions) {
                int x = row + dir[0];
                int y = col + dir[1];
                if(x >= 0 && x < rows &&
                y >= 0 && y < cols &&
                grid[x][y] == '1' &&
                !visited.contains(x+"#"+y)) {
                    q.add(x+"#"+y);
                    visited.add(x+"#"+y);
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
  {'1','1','1','1','0'},
  {'1','1','0','1','0'},
  {'1','1','0','0','0'},
  {'0','0','0','0','0'}
};
        Island island = new Island();
        System.out.println(island.numIslands(grid));
    }
}
