package org.neetcode.binary.search;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bot = rows-1;
        while(top <= bot) {
            int row = (top+bot)/2;
            if(target > matrix[row][cols-1]) {
                top = row+1;
            } else if(target < matrix[row][0]){
                bot = row-1;
            } else {
                break;
            }
        }
        if(!(top <= bot))
            return false;
        int row = (top+bot)/2;
        int l = 0, r = cols-1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(target == matrix[row][mid]) {
                return true;
            } else if(target > matrix[row][mid]) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(matrix,3));
    }
}
