package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConstrainedSubSeqSum {
    public int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p)-> p.num).reversed());
        int res = nums[0];
        pq.add(new Pair(nums[0], 0));
        for(int i = 1; i < nums.length; i++) {
            while (i-pq.peek().index > k) {
                pq.poll();
            }
            int curr_max = Math.max(nums[i], nums[i]+pq.peek().num);
            res = Math.max(res, curr_max);
            pq.add(new Pair(curr_max, i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10,2,-10,5,20};
        int k = 2;
        ConstrainedSubSeqSum constrainedSubSeqSum = new ConstrainedSubSeqSum();
        System.out.println(constrainedSubSeqSum.constrainedSubsetSum(nums, k));
    }

    class Pair {
        int num;
        int index;

        public Pair(int num, int index) {
            this.num = num;
            this.index = index;
        }
    }
}
