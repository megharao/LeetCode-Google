package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public Median() {
        minHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap = new PriorityQueue<>(Comparator.naturalOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() &&
                maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
        }
        if(maxHeap.size() > minHeap.size()+1) {
            minHeap.add(maxHeap.poll());
        }
        if(minHeap.size() > maxHeap.size()+1) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else {
            return (double)(minHeap.peek() + maxHeap.peek())/2;
        }
    }

    public static void main(String[] args) {
        Median medianFinder = new Median();
        medianFinder.addNum(3);    // arr = [1]
        medianFinder.addNum(2);
        medianFinder.addNum(7);// arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(4);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0
    }
}
