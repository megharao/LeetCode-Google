package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNum {

    PriorityQueue<Integer> pq;

    public int findKthLargest(int[] nums, int k) {
        pq = new PriorityQueue<>(nums.length, Comparator.reverseOrder());
        for(int i : nums) {
            pq.add(i);
        }
        int previous = 0;
        while(k > 0) {
            previous = pq.poll();
            k--;
        }
        return previous;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        KthLargestNum k = new KthLargestNum();
        System.out.println(k.findKthLargest(nums,4));
    }
}
