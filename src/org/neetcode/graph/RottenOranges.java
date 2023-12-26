package org.neetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottenOranges {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        int time = 0;
        int fresh = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    queue.add(i+"#"+j);
                }
            }
        }
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty() && fresh >0) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String[] co = queue.pollLast().split("#");
                int x = Integer.valueOf(co[0]);
                int y = Integer.valueOf(co[1]);
                for(int[] d : dir) {
                    int p = x + d[0];
                    int q = y + d[1];
                    if(p <0 || p >= rows || q < 0 || q >= cols || grid[p][q] != 1) {
                        continue;
                    }
                    if(grid[p][q] == 1) {
                        grid[p][q] = 2;
                        fresh--;
                        queue.addFirst(p+"#"+q);
                    }
                }
            }
            time++;
        }
        if(fresh > 0) {
            return -1;
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,1},{0,1,2}};
        RottenOranges rottenOranges = new RottenOranges();
        System.out.println(rottenOranges.orangesRotting(grid));
    }
}
