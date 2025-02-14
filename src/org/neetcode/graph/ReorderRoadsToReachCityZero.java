package org.neetcode.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ReorderRoadsToReachCityZero {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] con: connections) {
            adj[con[0]].add(new int[]{con[1], 1});
            adj[con[1]].add(new int[]{con[0], 0});
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        int changes = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int[] edge : adj[node]) {
                int neighbor = edge[0], isForward = edge[1];
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    changes += isForward;
                    queue.add(neighbor);
                }
            }
        }
        return changes;
    }

    public static void main(String[] args) {

    }
}
