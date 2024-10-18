package org.neetcode.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSubsequenceScore {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<Pair> pairList = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            pairList.add(new Pair(nums1[i],nums2[i]));
        }
        Comparator<Pair> comparator = Comparator.comparingLong(o -> o.n2);
        pairList.sort(comparator.reversed());
        PriorityQueue<Long> minHeap = new PriorityQueue<>(Comparator.naturalOrder());
        long n1Sum = 0;
        long res = 0;
        for(Pair pair: pairList) {
            n1Sum+=pair.n1;
            minHeap.add(pair.n1);
            if(minHeap.size()>k) {
                long n1pop = minHeap.poll();
                n1Sum -= n1pop;
            }
            if(minHeap.size() == k) {
                res = Math.max(res,n1Sum*pair.n2); //n2 points at min as it is reversely sorted
            }
        }
        return res;
    }

    class Pair {
        long n1;
        long n2;
        Pair(long n1, long n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,3,2}, nums2 = {2,1,3,4};
        int k = 3;
        MaxSubsequenceScore maxSubsequenceScore = new MaxSubsequenceScore();
        System.out.println(maxSubsequenceScore.maxScore(nums1,nums2,k));
    }
}
