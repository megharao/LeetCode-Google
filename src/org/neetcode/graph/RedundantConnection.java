package org.neetcode.graph;

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int[] rank = new int[edges.length+1];
        for(int i = 0; i < rank.length; i++) {
            rank[i] = 1;
        }
        for(int[] edge: edges) {
            if(!union(edge[0], edge[1], parent, rank)) {
                int[] res = new int[2];
                res[0] = edge[0];
                res[1] = edge[1];
                return res;
            }
        }
        return null;
    }

    public int find(int n, int[] parent) {
        int p = parent[n];
        while(p != parent[p]) {
            parent[p] = parent[parent[n]];
            p = parent[p];
        }
        return p;
    }

    public boolean union(int n1, int n2, int[] parent, int[] rank) {
        int p1 = find(n1, parent);
        int p2 = find(n2, parent);
        if(p1 == p2) return false;
        if(rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
