package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosest {
    PriorityQueue<Point> pq;
    int k;
    public int[][] kClosest(int[][] points, int k) {
        this.pq = new PriorityQueue<Point>(points.length, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.dis - o2.dis;
            }
        });
        this.k = k;
        for(int i = 0; i < points.length; i++) {
            int dis = Math.abs((points[i][0]*points[i][0]) + (points[i][1]*points[i][1]));
            Point p = new Point(points[i][0], points[i][1], dis);
            pq.add(p);
        }
        int[][] res = new int[k][2];
        int j = 0;
        while(k > 0) {
            Point p = pq.poll();
            res[j][0] = p.x;
            res[j][1] = p.y;
            j++;
            k--;
        }
        return res;

    }

    public static void main(String[] args) {
        KClosest k = new KClosest();
        int[][] input = {{2,2},{2,2},{2,2},{2,2},{2,2},{2,2},{1,1}};
        int[][] res = k.kClosest(input, 1);
        for(int i = 0; i < res.length; i++) {
            System.out.println(res[i][0] + " " +res[i][1] );
        }
    }
}

class Point{
    int x;
    int y;
    int dis;

    Point(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}
