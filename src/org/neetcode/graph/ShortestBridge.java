package org.neetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {
    private int N;
    private boolean[][] visited;
    private final int[][] direct = {{1,0},{0,1},{-1,0},{0,-1}};
    public int shortestBridge(int[][] grid) {
        N= grid.length;
        visited = new boolean[N][N];
        boolean found = false;
        for(int i = 0; i < N; i++) {
            if(found) break;
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
        }
        return bfs(grid);
    }

    public void dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= N || j >= N || grid[i][j] == 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for(int[] d: direct) {
            dfs(grid,i+d[0], j+d[1]);
        }
    }

    public int bfs(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visited[i][j]) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        int res = 0;
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i >= 0; i--) {
                int[] cell = queue.poll();
                int r = cell[0], c = cell[1];
                for(int[] d: direct) {
                    int curR = r + d[0], curC = c + d[1];
                    if(curR < 0 || curC < 0 || curR >= N || curC >= N || visited[curR][curC]) {
                        continue;
                    }
                    if(grid[curR][curC]==1) return res;
                    queue.add(new int[]{curR,curC});
                    visited[curR][curC] = true;
                }
            }
            res++;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
