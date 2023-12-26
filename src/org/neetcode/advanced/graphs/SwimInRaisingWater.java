package org.neetcode.advanced.graphs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SwimInRaisingWater {
    public int swimInWater(int[][] grid) {
        Set<String> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::getHeight));
        int n = grid.length;
        pq.add(new Pair(grid[0][0],0,0));
        visited.add(0+"#"+0);
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            if(p.row == n-1 && p.col == n-1) {
                return p.height;
            }
            for(int[] d: dir) {
                int nrow = p.row + d[0];
                int ncol = p.col + d[1];
                if(nrow < 0 || ncol < 0 || nrow == n || ncol ==n || visited.contains(nrow+"#"+ncol)) {
                    continue;
                }
                visited.add(nrow+"#"+ncol);
                pq.add(new Pair(Math.max(p.height,grid[nrow][ncol]), nrow, ncol));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,2},{1,3}};
        SwimInRaisingWater swimInRaisingWater = new SwimInRaisingWater();
        System.out.println(swimInRaisingWater.swimInWater(grid));
    }
}

class Pair{
    int height;
    int row;
    int col;
    Pair(int height, int row, int col) {
        this.height = height;
        this.row = row;
        this.col = col;
    }

    int getHeight(){
        return height;
    }
}
