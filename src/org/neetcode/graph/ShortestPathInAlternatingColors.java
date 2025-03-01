package org.neetcode.graph;

import java.util.*;

public class ShortestPathInAlternatingColors {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[] red = new ArrayList[n], blue = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            red[i] = new ArrayList<>();
            blue[i] = new ArrayList<>();
        }
        for(int[] edge : redEdges) red[edge[0]].add(edge[1]);
        for(int[] edge: blueEdges) blue[edge[0]].add(edge[1]);
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,-1}); //node, len, color
        Set<String> visited = new HashSet<>();
        visited.add("0,-1"); //node, color
        while(!queue.isEmpty()) {
            int[] nodeData = queue.poll();
            int node = nodeData[0], len = nodeData[1], color = nodeData[2];
            if(ans[node] == -1) ans[node] = len;
            if(color != 0) {
                for(int nei: red[node]) {
                    if(visited.add(nei+",0")) {
                        queue.offer(new int[] {nei, len+1,0});
                    }
                }
            }
            if(color != 1) {
                for(int nei:blue[node]) {
                    if(visited.add(nei+",1")) {
                        queue.offer(new int[]{nei, len+1,1});
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
