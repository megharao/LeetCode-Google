package org.neetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxPerformanceOfTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] eng = new int[n][2];
        for(int i = 0; i < n; i++) {
            eng[i][0] = efficiency[i];
            eng[i][1] = speed[i];
        }
        Comparator<int[]> comparator = Comparator.comparingInt(a -> a[0]);
        Arrays.sort(eng, comparator.reversed());
        long res = 0, currSpeed = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int[] a:eng) {
            if(minHeap.size() == k) {
                currSpeed -= minHeap.poll();
            }
            currSpeed += a[1];
            minHeap.add(a[1]);
            res = Math.max(res,a[0]*currSpeed);
        }
        return (int) (res % 1000000007);
    }
}
