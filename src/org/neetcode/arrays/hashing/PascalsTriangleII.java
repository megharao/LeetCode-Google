package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangleII {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i = 0; i < rowIndex; i++) {
            List<Integer> nextRow = new ArrayList<>(Collections.nCopies(res.size()+1, 0));

            for(int j = 0; j < res.size(); j++) {
                nextRow.set(j,nextRow.get(j)+res.get(j));
                nextRow.set(j+1, nextRow.get(j+1)+res.get(j));
            }
            res = nextRow;
        }
        return res;
    }

    public static void main(String[] args) {
        getRow(3);
    }
}
