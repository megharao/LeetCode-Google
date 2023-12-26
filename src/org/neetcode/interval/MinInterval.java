package org.neetcode.interval;

import java.util.*;

public class MinInterval {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<Data> pq = new PriorityQueue<>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.size != o2.size) {
                    return Integer.compare(o1.size, o2.size);
                } else {
                    return Integer.compare(o1.r,o2.r);
                }
            }
        });

        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[] copy = Arrays.copyOf(queries,queries.length);
        Arrays.sort(copy);
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        for(int q: copy) {
            while(i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                pq.add(new Data(r-l+1,r));
                i++;
            }
            while(!pq.isEmpty() && pq.peek().r < q) {
                pq.poll();
            }
            map.put(q,!pq.isEmpty() ? pq.peek().size : -1);
        }
        int[] res = new int[queries.length];
        for(int in = 0; in < queries.length; in++) {
            res[in] = map.get(queries[in]);
        }
        return res;
    }
}

class Data{
    int size;
    int r;

    Data(int size, int r) {
        this.size = size;
        this.r = r;
    }

    int getSize() {
        return size;
    }

    int getR() {
        return r;
    }
}
