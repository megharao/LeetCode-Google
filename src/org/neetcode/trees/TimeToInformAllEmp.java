package org.neetcode.trees;

import java.util.*;

public class TimeToInformAllEmp {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < manager.length; i++) {
            if(!adj.containsKey(manager[i])) {
                adj.put(manager[i],new ArrayList<>());
            }
            adj.get(manager[i]).add(i);
        }
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(headID,0));
        int time = 0;
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            time = Math.max(time,pair.time);
            if(adj.containsKey(pair.id)) {
                for (Integer emp : adj.get(pair.id)) {
                    queue.add(new Pair(emp, pair.time + informTime[pair.id]));
                }
            }
        }
        return time;
    }

    class Pair {
        int id;
        int time;
        Pair(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}
