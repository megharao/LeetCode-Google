package org.neetcode.math.geometry;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length;
        Set<String> zeroes = new HashSet<>();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(matrix[i][j] == 0) {
                    zeroes.add(i+"#"+j);
                }
            }
        }
        for(String indices : zeroes) {
            String[] in = indices.split("#");
            int i = Integer.parseInt(in[0]);
            int j = Integer.parseInt(in[1]);
            for(int k = 0; k < c; k++) {
                matrix[i][k] = 0;
            }
            for(int k = 0; k < r; k++) {
                matrix[k][j] = 0;
            }
        }
    }
}
