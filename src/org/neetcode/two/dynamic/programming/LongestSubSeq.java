package org.neetcode.two.dynamic.programming;

public class LongestSubSeq {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] grid = new int[m][n];
        for(int i = m-1; i >=0; i--) {
            for(int j = n-1; j >= 0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    int dia = 0;
                    if(i+1 <= m-1 && j+1 <= n-1) {
                        dia = grid[i+1][j+1];
                    }
                    grid[i][j] = 1 + dia;
                } else {
                    int right = 0;
                    int down = 0;
                    if(i+1 <= m-1) {
                        down = grid[i+1][j];
                    }
                    if(j+1 <= n-1) {
                        right = grid[i][j+1];
                    }
                    grid[i][j] = Math.max(right,down);
                }
            }
        }
        return grid[0][0];
    }
}
