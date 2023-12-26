package org.neetcode.greedy;

import java.util.HashSet;
import java.util.Set;

public class MergeTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();
        for(int i = 0; i < triplets.length; i++) {
            if(triplets[i][0] > target[0] || triplets[i][1] > target[1] || triplets[i][2] > target[2])
                continue;
            for(int j = 0; j < triplets[i].length; j++) {
                if(triplets[i][j] == target[j]){
                    good.add(j);
                }
            }
        }
        return good.size() == 3;
    }

    public static void main(String[] args) {
        int[][] triples = {{2,5,3},{1,8,4},{1,7,5}};
        int[] target = {2,7,5};
        MergeTriplet mergeTriplet = new MergeTriplet();
        System.out.println(mergeTriplet.mergeTriplets(triples,target));
    }
}
