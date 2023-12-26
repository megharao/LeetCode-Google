package org.neetcode.interval;

import java.util.Arrays;
import java.util.Comparator;

public class EraseOverLappingInterval {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int[] start = intervals[0];
        for(int i = 1; i < intervals.length; i++) {
            if(start[1] > intervals[i][0]) {
                res++;
            } else {
                start = intervals[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        EraseOverLappingInterval eraseOverLappingInterval = new EraseOverLappingInterval();
        System.out.println(eraseOverLappingInterval.eraseOverlapIntervals(intervals));
    }
}
