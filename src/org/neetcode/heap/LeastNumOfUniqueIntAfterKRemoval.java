package org.neetcode.heap;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumOfUniqueIntAfterKRemoval {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Pair::getCount));
        Map<Integer, Integer> numToCount = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            numToCount.put(arr[i], numToCount.getOrDefault(arr[i],0)+1);
        }
        numToCount.entrySet().stream().forEach(entry -> {
            priorityQueue.add(new Pair(entry.getKey(), entry.getValue()));
        });
        while(k > 0) {
            Pair pair = priorityQueue.poll();
            if(pair.getCount() != 1) {
                pair.count = pair.getCount()-1;
                priorityQueue.add(pair);
            }
            k--;
        }
        return priorityQueue.size();
    }

    public static void main(String[] args) {
        int[] arr = {4,3,1,1,3,3,2};
        LeastNumOfUniqueIntAfterKRemoval obj = new LeastNumOfUniqueIntAfterKRemoval();
        System.out.println(obj.findLeastNumOfUniqueInts(arr, 3));
    }

    class Pair{
        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }

        int num;
        int count;

        public Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
