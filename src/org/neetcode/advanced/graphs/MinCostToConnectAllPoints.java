package org.neetcode.advanced.graphs;

import java.util.*;

public class MinCostToConnectAllPoints {
    public int minCostConnectPoints(int[][] points) {
        int cost = 0;
        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getDis));
        pq.add(new Pair(0, 0, 0));

        int num = points.length;

        while(pq.size()!=0 && visited.size()<num){
            Pair curr = pq.poll();

            int endId = curr.y;
            int currCost = curr.dis;

            if(visited.contains(endId)){
                continue;
            }
            visited.add(endId);

            cost = cost + currCost;

            for(int i=0; i<num; i++){
                if(!visited.contains(i)){
                    pq.add(new Pair(endId, i, distance(points, endId, i)));
                }
            }
        }
        return cost;
    }

    private int distance(int[][] points, int i, int j){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        MinCostToConnectAllPoints minCostToConnectAllPoints = new MinCostToConnectAllPoints();
        System.out.print(minCostToConnectAllPoints.minCostConnectPoints(points));
    }

    class Pair{
        public int getDis() {
            return dis;
        }

        int dis;

        int x;
        int y;

        Pair(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
