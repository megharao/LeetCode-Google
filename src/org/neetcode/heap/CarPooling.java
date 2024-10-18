package org.neetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[1]);
        Arrays.sort(trips,comparator);
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p->p.end));
        int currPass = 0;
        for(int[] t:trips) {
            while(!minHeap.isEmpty() && minHeap.peek().end <= t[1]) {
                currPass -= minHeap.poll().numOfPass;
            }
            currPass += t[0];
            if(currPass > capacity) {
                return false;
            }
            minHeap.add(new Pair(t[2],t[0]));
        }
        return true;
    }

    class Pair {
        int end;
        int numOfPass;

        public Pair(int end, int numOfPass) {
            this.end = end;
            this.numOfPass = numOfPass;
        }
    }
}
