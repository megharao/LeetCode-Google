package org.neetcode.greedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HandofStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }
        Map<Integer, Integer> count = new HashMap<>();
        for(int h : hand) {
            if(count.containsKey(h)) {
                int c = count.get(h);
                count.put(h,c+1);
            } else {
                count.put(h,1);
            }
        }
        PriorityQueue<Integer>  pq = new PriorityQueue<>();
        pq.addAll(count.keySet());
        while(!pq.isEmpty()) {
            int first = pq.peek();
            for(int i = first; i < first+groupSize; i++) {
                if(!count.containsKey(i)) {
                    return false;
                }
                int c = count.get(i);
                count.put(i,c-1);
                if(count.get(i) == 0) {
                    if(i != pq.peek()) {
                        return false;
                    }
                    pq.poll();
                }
            }
        }
        return true;
    }
}
