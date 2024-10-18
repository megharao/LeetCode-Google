package org.neetcode.heap;

import java.util.PriorityQueue;

public class SeatManager {
    PriorityQueue<Integer> unreserved = new PriorityQueue<>();
    public SeatManager(int n) {
        for(int i = 1; i <= n; i++) {
            unreserved.add(i);
        }
    }

    public int reserve() {
        return unreserved.poll();
    }

    public void unreserve(int seatNumber) {
        unreserved.add(seatNumber);
    }
}
