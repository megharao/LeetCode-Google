package org.neetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        double res = Double.MAX_VALUE;
        Wage[] pairs = new Wage[quality.length];
        for(int i = 0; i < quality.length; i++) {
            pairs[i] = new Wage((double)wage[i]/quality[i], quality[i]);
        }
        Arrays.sort(pairs, Comparator.comparingDouble(p -> p.ratio)); //sort based on ratio
        PriorityQueue<Integer> qualityHeap = new PriorityQueue<>(Comparator.reverseOrder()); // sort max heap based on quality
        int totalQuality = 0;
        for(int i = 0; i < pairs.length; i++) {
            qualityHeap.add(pairs[i].quality);
            totalQuality += pairs[i].quality;
            if(qualityHeap.size() > k) {
                totalQuality -= qualityHeap.poll();;
            }
            if(qualityHeap.size() == k) {
                res = Math.min(res, totalQuality*pairs[i].ratio);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] quality = {3,1,10,10,1}, wage = {4,8,2,2,7};
        int k = 3;
        MinCostToHireKWorkers minCostToHireKWorkers = new MinCostToHireKWorkers();
        System.out.println(minCostToHireKWorkers.mincostToHireWorkers(quality, wage, k));
    }

    class Wage {
        double ratio;
        int quality;

        public Wage(double ratio, int quality) {
            this.ratio = ratio;
            this.quality = quality;
        }
    }
}
