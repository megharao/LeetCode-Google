package org.neetcode.arrays.hashing;

public class ChampagneGlasses {
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[] prevRow = {poured}; //Flow
        for (int i = 1; i < query_row + 1; i++) {
            double[] currRow = new double[i + 1];
            for (int j = 0; j < i; j++) {
                double extra = prevRow[j] - 1;
                if (extra > 0) {
                    currRow[j] += 0.5 * extra;
                    currRow[j + 1] += 0.5 * extra;
                }
            }
            prevRow = currRow;
        }
        return prevRow[query_glass];
    }

    public static void main(String[] args) {
        int poured = 4, query_row = 2, query_glass = 2;
        System.out.println(champagneTower(poured,query_row,query_glass));
    }
}
