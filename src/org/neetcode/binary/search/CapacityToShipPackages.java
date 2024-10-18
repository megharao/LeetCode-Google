package org.neetcode.binary.search;

import java.util.Arrays;

public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int lowerBound = Arrays.stream(weights).max().getAsInt();
        int upperBound = Arrays.stream(weights).sum();
        int minCapacity = upperBound;
        while(lowerBound <= upperBound) {
            int mid = (lowerBound+upperBound)/2;
            if(canShip(mid, weights, days)) {
                minCapacity = Math.min(minCapacity, mid);
                upperBound = mid-1;
            } else {
                lowerBound = mid+1;
            }
        }
        return minCapacity;
    }

    public boolean canShip(int cap, int[] weights, int days) {
        int ships = 1, currCap = cap;
        for(int w: weights) {
            if(currCap - w < 0) {
                ships++;
                currCap = cap;
            }
            currCap -= w;
        }
        return ships <= days;
    }
}
