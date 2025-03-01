package org.neetcode.graph;

import java.util.*;

public class FindClosestNodeToGiveTwoNodes {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++) {
            if(edges[i] != -1) {
                adj[i].add(edges[i]);
            }
        }
        int[] node1Dist = bfs(node1, n, adj);
        int[] node2Dist = bfs(node2, n, adj);

        int res = -1, resDist = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(node1Dist[i] != -1 && node2Dist[i] != -1) {
                int dist = Math.max(node1Dist[i],node2Dist[i]);
                if(dist < resDist) {
                    resDist = dist;
                    res = i;
                }
            }
        }
        return res;
    }

    private int[] bfs(int src, int n, List<Integer>[] adj) {
        int[] distMap = new int[n];
        Arrays.fill(distMap,-1);
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src,0});
        distMap[src] = 0;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0], dist = curr[1];
            for(int nei: adj[node]) {
                if(distMap[nei] == -1) {
                    q.offer(new int[]{nei, dist+1});
                    distMap[nei] = dist+1;
                }
            }
        }
        return distMap;
    }

    public static void main(String[] args) {

    }
}
