package org.neetcode.arrays.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumOfSubMatrixSumToTarget {

    public static int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] sub_sum = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int top = i > 0 ? sub_sum[i-1][j] : 0;
                int left = j > 0 ? sub_sum[i][j-1] : 0;
                int top_left = (i > 0 && j > 0) ? sub_sum[i-1][j-1] : 0;
                sub_sum[i][j] = matrix[i][j] + top + left - top_left;
            }
        }
        int res = 0;
        for(int row1 = 0; row1 < rows; row1++) {
            for(int row2 = row1; row2 < rows; row2++) {
                Map<Integer, Integer> currSumCount = new HashMap<>();
                currSumCount.put(0,1);
                for(int col = 0; col < cols; col++) {
                    int top = row1 > 0 ? sub_sum[row1-1][col] : 0;
                    int currSum = sub_sum[row2][col] - top;
                    int diff = currSum - target;
                    if(currSumCount.containsKey(diff)) {
                        res += currSumCount.get(diff);
                    }
                    currSumCount.put(currSum, currSumCount.getOrDefault(currSum, 0)+1);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        numSubmatrixSumTarget(matrix, 0);
    }
}
