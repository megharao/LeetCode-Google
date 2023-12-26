package org.neetcode.advanced.graphs;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<Node>> adj = new HashMap<>();
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparing(Node::getWght));
        Set<Integer> visited = new HashSet<>();
        for(int[] t:times) {
            if(!adj.containsKey(t[0])) {
                adj.put(t[0],new ArrayList<>());
            }
            adj.get(t[0]).add(new Node(t[0],t[1],t[2]));
        }
        q.add(new Node(0,k,0));
        int res = 0;
        while(!q.isEmpty()) {
                Node node = q.poll();
                if(!visited.contains(node.dest)) {
                    res = Math.max(res, node.wght);
                    if (adj.get(node.dest) != null) {
                        for(Node node1 : adj.get(node.dest)) {
                            if(!visited.contains(node1.dest)) {
                                q.add(new Node(node1.source, node1.dest, node.wght+node1.wght));
                            }
                        }
                    }
                    visited.add(node.dest);
                }
        }
        if(visited.size() != n) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] times = {{1,2,1},{2,3,2},{1,3,4}};
        NetworkDelayTime networkDelayTime = new NetworkDelayTime();
        System.out.println(networkDelayTime.networkDelayTime(times,3,1));
    }
}

class Node{
    int source;
    int dest;
    int wght;

    Node(int source, int dest, int wght) {
        this.source = source;
        this.dest = dest;
        this.wght = wght;
    }

    int getWght(){
        return this.wght;
    }
}
