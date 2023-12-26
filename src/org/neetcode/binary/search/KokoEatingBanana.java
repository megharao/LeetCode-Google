package org.neetcode.binary.search;

import java.util.Arrays;

public class KokoEatingBanana {
    public static int minEatingSpeed(int[] piles, int h) {
        if(h < piles.length) {
            return 0;
        }
        Arrays.sort(piles);
        int max = piles[piles.length-1];
        int low = 0;
        int speed = max;
        while(low <= max) {
            int mid = low + (max-low)/2;
            int hr = getHr(piles, mid);
            if(hr <= h) {
                speed = Math.min(speed,mid);
                max = mid - 1;
            } else {
                low = mid+1;
            }
        }
        return speed;
    }

    public static int getHr(int[] piles, int mid) {
        int res = 0;
        for(int i : piles) {
            res += Math.ceil((double)i/mid);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        System.out.println(minEatingSpeed(piles,6));
    }
}
