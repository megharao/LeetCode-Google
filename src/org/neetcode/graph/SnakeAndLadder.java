package org.neetcode.graph;

import java.util.*;

public class SnakeAndLadder {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> q = new LinkedList<>(); //[square, moves]
        q.offer(new int[]{1, 0});
        Set<Integer> visit = new HashSet<>();

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int square = cur[0], moves = cur[1];

            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                int[] pos = intToPos(nextSquare, n);
                int r = pos[0], c = pos[1];
                if (board[r][c] != -1) {
                    nextSquare = board[r][c];
                }
                if (nextSquare == n * n) return moves + 1;
                if (!visit.contains(nextSquare)) {
                    visit.add(nextSquare);
                    q.offer(new int[]{nextSquare, moves + 1});
                }
            }
        }
        return -1;
    }

    private int[] intToPos(int square, int n) {
        int r = (square - 1) / n;
        int c = (square - 1) % n;
        if (r % 2 == 1) c = n - 1 - c;
        r = n - 1 - r;
        return new int[]{r, c};
    }

    public static void main(String[] args) {

    }
}
