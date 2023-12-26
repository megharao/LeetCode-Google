package org.neetcode.math.geometry;

public class RotateMatrixInPlace {
    public void rotate(int[][] matrix) {
        int n = matrix.length-1, m = (n+1) / 2;
        for(int i = 0; i < m; i++, n--) {
            for (int j = i; j < n; j++) {
                int xJ = matrix.length - j - 1;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[xJ][i];  // left to top
                matrix[xJ][i] = matrix[n][xJ]; // bottom to left
                matrix[n][xJ] = matrix[j][n];  // right to bottom
                matrix[j][n] = temp;      // top to right
            }
        }
    }
}
