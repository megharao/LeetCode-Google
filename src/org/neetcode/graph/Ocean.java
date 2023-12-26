package org.neetcode.graph;

import java.util.*;

public class Ocean {

    int row;
    int col;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        row = heights.length;
        col = heights[0].length;
        Set<Pair> pacific = new HashSet<>();
        Set<Pair> atlantic = new HashSet<>();
        for(int c = 0; c < col; c++) {
            dfs(0,c,pacific,heights[0][c],heights);
            dfs(row-1,c,atlantic,heights[row-1][c],heights);
        }
        for(Pair p : pacific) {
            res.add(Arrays.asList(p.x,p.y));
        }
        for(Pair p : atlantic) {
            res.add(Arrays.asList(p.x,p.y));
        }
        return res;
    }

    public void dfs(int r, int c, Set<Pair> sea, int prevHeight,int[][] heights) {
        if(sea.contains(new Pair(r,c)) || r < 0 || c <0 || r >= row || c >= col || heights[r][c] < prevHeight) {
            return;
        }
        sea.add(new Pair(r,c));
        dfs(r+1, c, sea, heights[r][c], heights);
        dfs(r-1, c, sea, heights[r][c], heights);
        dfs(r, c+1, sea, heights[r][c], heights);
        dfs(r, c-1, sea, heights[r][c], heights);
    }

    public static void main(String[] args) {

    }

    class Pair{
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
