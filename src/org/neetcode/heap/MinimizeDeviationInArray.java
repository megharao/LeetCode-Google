package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return Integer.compare(o1.newVal,o2.newVal);
            }
        });
        int heapMax = 0;
        for(int n:nums) {
            //try minimise the num before adding to heap
            int temp = n;
            while(n%2 ==0)
                n = n/2;
            minHeap.add(new Pair(n,Math.max(temp,n*2))); //for odd num multiply by 2
            heapMax = Math.max(heapMax,n);
        }
        int res = Integer.MAX_VALUE;
        while(minHeap.size() == nums.length) {
            Pair pair = minHeap.poll();
            res = Math.min(res,heapMax-pair.newVal);
            if(pair.newVal < pair.oriVal) {
                minHeap.add(new Pair(pair.newVal*2,pair.oriVal));
                heapMax = Math.max(heapMax,pair.newVal*2);
            }
        }
        return res;
    }

    class Pair {
        int newVal;
        int oriVal;
        Pair(int newVal, int oriVal) {
            this.newVal = newVal;
            this.oriVal = oriVal;
        }
    }
}
