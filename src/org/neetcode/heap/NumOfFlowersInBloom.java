package org.neetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NumOfFlowersInBloom {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        int[] res = new int[people.length];
        People[] p = new People[people.length];
        for(int i = 0; i < people.length; i++) {
            p[i] = new People(people[i], i);
        }
        Arrays.sort(p, Comparator.comparingInt(i -> i.time));
        int count = 0;
        PriorityQueue<Integer> startHeap = new PriorityQueue<>(Comparator.naturalOrder());
        PriorityQueue<Integer> endHeap = new PriorityQueue<>(Comparator.naturalOrder());
        for(int i = 0; i < flowers.length; i++) {
            startHeap.add(flowers[i][0]);
            endHeap.add(flowers[i][1]);
        }
        for(People pe: p) {
            while(!startHeap.isEmpty() && startHeap.peek() <= pe.time) {
                startHeap.poll();
                count++;
            }
            while(!endHeap.isEmpty() && endHeap.peek() < pe.time) {
                endHeap.poll();
                count--;
            }
            res[pe.index] = count;
        }

        return res;
    }

    public static void main(String[] args) {

    }

    class People{
        int time;
        int index;


        public People(int time, int index) {
            this.time = time;
            this.index = index;
        }
    }
}
