package org.neetcode.trees;

import java.util.Arrays;

public class UniqueBST {
    public int numTrees(int n) {
        //numTrees[4] = numTrees[0]*numTrees[3]+
        //              numTrees[1]*numTrees[2]+
        //              numTrees[1]*numTrees[2]+
        //              numTrees[3]*numTrees[0]
        int[] numTrees = new int[n+1];
        Arrays.fill(numTrees,1);
        //0 node - 1 tree
        //1 node - 1 tree
        for(int nodes = 2; nodes < n+1; nodes++) {
            int total = 0;
            for(int root = 1; root < nodes+1; root++) {
                int left = root -1;
                int right = nodes-root;
                total+=numTrees[left]*numTrees[right];
            }
            numTrees[nodes] = total;
        }
        return numTrees[n];
    }
}
