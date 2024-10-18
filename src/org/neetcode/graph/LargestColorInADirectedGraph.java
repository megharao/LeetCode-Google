package org.neetcode.graph;

import java.util.*;

public class LargestColorInADirectedGraph {
    Set<Integer> path = new HashSet<>();
    Set<Integer> visit = new HashSet<>();

    int[][] count;
    String colors;
    Map<Integer, List<Integer>> adj;
    public int largestPathValue(String colors, int[][] edges) {
        this.colors = colors;
        adj = new HashMap<>();
        for(int[] edge: edges) {
            if(!adj.containsKey(edge[0])) {
                adj.put(edge[0],new ArrayList<>());
            }
            adj.get(edge[0]).add(edge[1]);
        }
        int res = Integer.MIN_VALUE;
        int n = colors.length();
        count = new int[n][26];
        for(int i = 0; i < n; i++) {
            res = Math.max(res, dfs(i));
        }
        return res == Integer.MIN_VALUE ? -1 : res;
    }

    public int dfs(int i) {
        if(path.contains(i)) {
            return Integer.MIN_VALUE;
        }
        if(visit.contains(i)) {
            return 0;
        }
        int colorIndex =  colors.charAt(i)-'a';
        if(adj.get(i) != null) {
            visit.add(i);
            path.add(i);
            count[i][colorIndex] = 1;
            for (int neigh : adj.get(i)) {
                if (dfs(neigh) == Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                for (int c = 0; c < 26; c++) {
                    count[i][c] = Math.max(count[i][c], (c == colorIndex ? 1 : 0) + count[neigh][c]);
                }
            }
            path.remove(i);
            return Arrays.stream(count[i]).max().getAsInt();
        }
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        int[][] edges = {{1,2},{2,1}};
        LargestColorInADirectedGraph largestColorInADirectedGraph = new LargestColorInADirectedGraph();
        System.out.println(largestColorInADirectedGraph.largestPathValue("aa", edges));
    }
}
