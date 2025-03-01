package org.neetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class MinFuelCostToReportToCapital {
    List<Integer>[] adj;
    int res = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length+1;
        adj = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int[] road: roads) {
            adj[road[0]].add(road[1]);
            adj[road[1]].add(road[0]);
        }
        dfs(0,-1,seats);
        return res;
    }

    public int dfs(int node, int parent, int seats) {
        int passengers = 0;
        for(int child: adj[node]) {
            if(child != parent) {
                int p = dfs(child, node, seats);
                passengers += p;
                res += Math.ceil((double) p/seats);
            }
        }
        return passengers+1;
    }

    public static void main(String[] args) {

    }
}
