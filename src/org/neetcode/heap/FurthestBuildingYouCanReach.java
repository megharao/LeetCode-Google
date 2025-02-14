package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0; i < heights.length-1; i++) {
            int diff = heights[i+1] - heights[i];
            if(diff <= 0) {
                continue;
            }
            bricks -= diff;
            priorityQueue.add(diff);
            if(bricks < 0) {
                if(ladders == 0) {
                    return i;
                }
                ladders -= 1;
                int maxJump = priorityQueue.poll();
                bricks += maxJump;
            }
        }
        return heights.length-1;
    }

    public static void main(String[] args) {

    }
}
