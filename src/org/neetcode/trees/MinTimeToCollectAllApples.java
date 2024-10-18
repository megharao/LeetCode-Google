package org.neetcode.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinTimeToCollectAllApples {
    Map<Integer, List<Integer>> adj;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new HashMap<>();
        for(int[] edge : edges) {
            if(!adj.containsKey(edge[0])) {
                adj.put(edge[0],new ArrayList<>());
            }
            adj.get(edge[0]).add(edge[1]);
            if(!adj.containsKey(edge[1])) {
                adj.put(edge[1],new ArrayList<>());
            }
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(0,-1,hasApple);
    }

    public int dfs(int curr, int par, List<Boolean> hasApple) {
        int time = 0;
        for(int child : adj.get(curr)) {
            if(child == par) {
                continue;
            }
            int childTime = dfs(child, curr, hasApple);
            if(childTime > 0 || hasApple.get(child)) {
                time += 2 + childTime;
            }
        }
        return time;
    }
}
