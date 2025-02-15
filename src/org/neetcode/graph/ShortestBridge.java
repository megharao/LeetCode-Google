package org.neetcode.graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestBridge {
        private int N;
        private boolean[][] visited;
        private final int[][] direct = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int shortestBridge(int[][] grid) {
            N = grid.length;
            visited = new boolean[N][N];

            boolean found = false;
            for (int r = 0; r < N; r++) {
                if (found) break;
                for (int c = 0; c < N; c++) {
                    if (grid[r][c] == 1) {
                        dfs(grid, r, c);
                        found = true;
                        break;
                    }
                }
            }

            return bfs(grid);
        }

        private void dfs(int[][] grid, int r, int c) {
            if (r < 0 || c < 0 || r >= N || c >= N || grid[r][c] == 0 || visited[r][c])
                return;

            visited[r][c] = true;

            for (int[] d : direct) {
                dfs(grid, r + d[0], c + d[1]);
            }
        }

        private int bfs(int[][] grid) {
            Queue<int[]> q = new ArrayDeque<>();
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c]) {
                        q.offer(new int[]{r, c});
                    }
                }
            }

            int res = 0;
            while (!q.isEmpty()) {
                for (int i = q.size(); i > 0; i--) {
                    int[] cell = q.poll();
                    int r = cell[0], c = cell[1];

                    for (int[] d : direct) {
                        int curR = r + d[0], curC = c + d[1];

                        if (curR < 0 || curC < 0 || curR >= N || curC >= N || visited[curR][curC])
                            continue;

                        if (grid[curR][curC] == 1) return res;

                        q.offer(new int[]{curR, curC});
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
