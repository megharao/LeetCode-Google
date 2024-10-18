package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> maxProfits = new PriorityQueue<>(Comparator.reverseOrder()); //only projects we can afford currently
        PriorityQueue<int[]> minCapital = new PriorityQueue<>(Comparator.comparingInt(a->a[0])); //(cap,profit) //projects we can pick later if we can afford
        for(int i = 0; i < profits.length; i++) {
            minCapital.add(new int[] {capital[i],profits[i]});
        }
        for(int i = 0; i < k; i++) {
            while(!minCapital.isEmpty() && minCapital.peek()[0] <= w) {
                maxProfits.add(minCapital.poll()[1]);
            }
            if(maxProfits.isEmpty()) {
                break;
            }
            w += maxProfits.poll();
        }
        return w;
    }
}
