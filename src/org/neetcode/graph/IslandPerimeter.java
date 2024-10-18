package org.neetcode.graph;

import java.util.HashSet;
import java.util.Set;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        Set<String> visited = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    return dfs(i,j,grid,visited);
                }
            }
        }
        return 0;
    }

    public int dfs(int i, int j, int[][] grid, Set<String> visited) {
        if((i >= grid.length || j >= grid[0].length || i <0 || j <0) || grid[i][j] == 0) {
            return 1;
        }
        if(visited.contains(i+"#"+j)) {
            return 0;
        }
        visited.add(i+"#"+j);
        int perim = dfs(i,j+1,grid,visited) +
                dfs(i+1,j,grid,visited) +
                dfs(i-1,j,grid,visited) +
                dfs(i,j-1,grid,visited);
        return perim;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        IslandPerimeter islandPerimeter = new IslandPerimeter();
        islandPerimeter.islandPerimeter(grid);
    }
}
