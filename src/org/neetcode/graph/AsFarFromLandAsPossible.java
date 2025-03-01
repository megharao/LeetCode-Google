package org.neetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[] dir = {0,1,0,-1,0};
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) {
                    visited[r][c] = true;
                    queue.add(new int[] {r,c});
                }
            }
        }
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            for(int i = queue.size(); i >= 0; i--) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];
                for(int d=0; d <4; d++) {
                    int newR = r+dir[d], newC = c+dir[d+1];
                    if(newR >= 0 && newC >= 0 && newR < n && newC <c && !visited[newR][newC]) {
                        queue.offer(new int[]{newR,newC});
                        visited[newR][newC] = true;
                    }
                }
            }
        }
        return res > 1 ? res-1:-1;
    }

}
