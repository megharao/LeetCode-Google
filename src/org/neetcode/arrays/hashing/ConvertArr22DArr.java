package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertArr22DArr {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int n: nums) {
            int row = countMap.getOrDefault(n, 0);
            if(res.size() == row) {
                res.add(new ArrayList<>());
            }
            res.get(row).add(n);
            countMap.put(n, countMap.getOrDefault(n,0)+1);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
