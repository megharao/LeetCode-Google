package org.neetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

    private Boolean[] safe;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        safe = new Boolean[n];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(dfs(graph, i)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean dfs(int[][] graph, int i) {
        if(safe[i] != null) {
            return safe[i];
        }
        safe[i] = false;
        for(int nei: graph[i]) {
            if(!dfs(graph, nei)) {
                return false;
            }
        }
        safe[i] = true;
        return true;
    }

    public static void main(String[] args) {

    }
}
