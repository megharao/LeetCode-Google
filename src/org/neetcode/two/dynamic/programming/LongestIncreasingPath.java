package org.neetcode.two.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class LongestIncreasingPath {

    int rows, cols;

    Map<String, Integer> dp;

    int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
         this.rows = matrix.length;
         this.cols = matrix[0].length;
         this.matrix = matrix;
        this.dp = new HashMap<>();
        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(i,j,-1);
            }
        }
        return dp.values().stream().max(Integer::compareTo).get();
    }

    public int dfs(int r, int c, int prevVal) {
        if(r < 0 || r == rows || c <0 || c == cols ||  matrix[r][c]<= prevVal) {
            return 0;
        } if(dp.containsKey(r+"#"+c)) {
            return dp.get(r+"#"+c);
        }
        int res = 1;
        res = Math.max(res, 1+dfs(r+1,c,matrix[r][c]));
        res = Math.max(res, 1+dfs(r,c+1,matrix[r][c]));
        res = Math.max(res, 1+dfs(r-1,c,matrix[r][c]));
        res = Math.max(res, 1+dfs(r,c-1,matrix[r][c]));
        dp.put(r+"#"+c,res);
        return res;
    }

    public static void main(String[] args) {

    }
}
