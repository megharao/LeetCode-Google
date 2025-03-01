package org.neetcode.graph;

import java.util.*;

public class MinScoreOfPathBwTwoCities {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] adj = new ArrayList[n+1];
        for(int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] road: roads) {
            adj[road[0]].add(new int[]{road[1], road[2]});
            adj[road[1]].add(new int[]{road[0], road[2]});
        }
        int res = Integer.MAX_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(1);
        visited.add(1);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int[] edge: adj[node]) {
                int nei = edge[0], dis = edge[1];
                res = Math.min(res,dis);
                if(!visited.contains(nei)) {
                    queue.add(nei);
                    visited.add(nei);
                }
            }
        }
        return res;
    }
}
