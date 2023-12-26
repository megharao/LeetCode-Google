package org.neetcode.interval;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[] start = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(start[1] >= intervals[i][0]) {
                int[] merged = new int[2];
                merged[0] = Math.min(start[0],intervals[i][0]);
                merged[1] = Math.max(start[1],intervals[i][1]);
                start = merged;
            } else {
                result.add(start);
                start = intervals[i];
            }
        }
        result.add(start);
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        MergeInterval insertInterval = new MergeInterval();
        System.out.println(insertInterval.merge(intervals));
    }
}
