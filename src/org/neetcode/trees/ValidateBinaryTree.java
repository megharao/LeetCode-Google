package org.neetcode.trees;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class ValidateBinaryTree {
    Set<Integer> visited = new HashSet<>();
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> hasParent = new HashSet<>();
        IntStream.of(leftChild).forEach(hasParent::add);
        IntStream.of(rightChild).forEach(hasParent::add);

        hasParent.remove(-1);

        if(hasParent.size() == n) {
            return false;
        }

        int root = -1;
        for(int i = 0; i < n; i++) {
            if(!hasParent.contains(i)) {
                root = i;
                break;
            }
        }

        return dfs(root, leftChild, rightChild) && visited.size() == n;

    }

    public boolean dfs(int i, int[] leftChild, int[] rightChild) {
        if(i==-1) {
            return true;
        }
        if(visited.contains(i)) {
            return false;
        }
        visited.add(i);
        return dfs(leftChild[i], leftChild, rightChild) && dfs(rightChild[i], leftChild, rightChild);
    }
}
