package org.neetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        if(grid[0][0] == 1 || grid[N-1][N-1] == 1) return -1;
        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0,1});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], len = cell[2];
            if(r == N-1 || c==N-1) return len;
            for(int[] d: directions) {
                int nr = r+d[0], nc = c+d[1];
                if(nr >= 0 && nc >= 0 && nr < N && nc <N
                && grid[nr][nc]==0 && visited[nr][nc] == false) {
                    queue.offer(new int[]{nr,nc,len+1});
                    visited[nr][nc] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
