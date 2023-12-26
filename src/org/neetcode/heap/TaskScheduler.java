package org.neetcode.heap;

import java.util.*;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Comparator.reverseOrder());
        Map<String, Integer> counter = new HashMap<>();
        for(char c: tasks) {
            String s = String.valueOf(c);
            if(counter.containsKey(s)) {
                counter.put(s,counter.get(s)+1);
            } else {
                counter.put(s, 1);
            }
        }
        counter.values().stream().forEach(c -> pq.add(c));
        int time = 0;
        Queue<Pair> queue = new ArrayDeque<>();
        while(!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                int count = pq.poll();
                count--;
                if(count != 0) {
                    queue.add(new Pair(count,time+n));
                }
            }
            if(!queue.isEmpty() && queue.peek().time == time) {
                pq.add(queue.poll().occ);
            }
        }
        return time;
    }

    public static void main(String[] args) {
        TaskScheduler t = new TaskScheduler();
        char[] tasks = {'A','A','A','B','B','B'};
        System.out.println(t.leastInterval(tasks,2));
    }

    class Pair {
        int occ;
        int time;

        Pair(int occ, int time) {
            this.occ = occ;
            this.time = time;
        }
    }
}

class Task {
    char c;
    int occ;
}
