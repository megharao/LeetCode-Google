package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StoneWght {
    PriorityQueue<Integer> pq;
    int lastWght = 0;
    public int lastStoneWeight(int[] stones) {
        pq = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for(int i : stones) {
            pq.add(i);
        }
        while(pq.size() > 1) {
            lastWght = pq.poll();
            int wght = pq.poll();
            if(lastWght != wght) {
                pq.add(Math.abs(lastWght-wght));
            }
        }
        if(pq.isEmpty()) {
            return 0;
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2,2};
        StoneWght stoneWght = new StoneWght();
        System.out.println(stoneWght.lastStoneWeight(stones));
    }
}
