package org.neetcode.two.dynamic.programming;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[m-1][n-1] = 1;
        for(int i = m-1; i >= 0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(i+1 <= m-1) {
                    grid[i][j] = grid[i][j] + grid[i+1][j];
                }
                if(j+1 <= n-1) {
                    grid[i][j] = grid[i][j] + grid[i][j+1];
                }
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3,7));
    }
}
