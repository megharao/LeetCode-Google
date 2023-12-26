package org.neetcode.math.geometry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int r = matrix.length;
        int c = matrix[0].length;
        Set<String> visited = new HashSet<>();
        int i = 0, j = 0;
        int k = 0;
        boolean flag = true;
        while(flag) {
            if(!visited.contains(i+"#"+j) && i < r && j < c && i >= 0 && j >= 0) {
                res.add(matrix[i][j]);
                visited.add(i+"#"+j);
                int[] currdir = dir[k];
                i = i + currdir[0];
                j = j + currdir[1];
            } else {
                int[] currdir = dir[k];
                i = i - currdir[0];
                j = j - currdir[1];
                k = (k+1) % 4;
                currdir = dir[k];
                i = i + currdir[0];
                j = j + currdir[1];
            }
            if(visited.size() == r*c) {
                flag = false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        spiralMatrix.spiralOrder(matrix).stream().forEach(i -> System.out.println(i+ " "));
    }
}
