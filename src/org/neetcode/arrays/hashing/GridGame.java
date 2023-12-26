package org.neetcode.arrays.hashing;

import java.util.Arrays;

public class GridGame {
    public long gridGame(int[][] grid) {
        long ans = Long.MAX_VALUE, lowerLeft = 0, upperRight = 0;
        for (int cell : grid[0]) {
            upperRight += cell;
        }
        for (int i = 0; i < grid[0].length; ++i) {
            upperRight -= grid[0][i];
            ans = Math.min(ans, Math.max(upperRight, lowerLeft));
            lowerLeft += grid[1][i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,5,4},{1,5,1}};
//        int[][] grid = {{3,3,1},{8,5,2}};
        GridGame gridGame = new GridGame();
        System.out.println(gridGame.gridGame(grid));
    }
}
