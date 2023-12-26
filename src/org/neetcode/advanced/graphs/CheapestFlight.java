package org.neetcode.advanced.graphs;

import java.util.HashMap;
import java.util.Map;

public class CheapestFlight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Integer> prices = new HashMap<>();
        Map<Integer, Integer> tempPrices = new HashMap<>();
        for(int i = n; i >= 0; i--) {
            tempPrices.put(i, Integer.MAX_VALUE);
            prices.put(i, Integer.MAX_VALUE);
        }
        prices.put(src,0);
        tempPrices.put(src,0);
        for(int i = 0; i < k+1; i++) {
            for(int[] flight: flights) {
                int s = flight[0];
                int d = flight[1];
                int cost = flight[2];
                if(prices.get(s) == Integer.MAX_VALUE) continue;
                if(prices.get(s) + cost < tempPrices.get(d)) {
                    tempPrices.put(d,prices.get(s) + cost);
                }
            }
            prices = Map.copyOf(tempPrices);
        }
        return prices.get(dst) == Integer.MAX_VALUE ? -1 : prices.get(dst);
    }
    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        CheapestFlight cheapestFlight = new CheapestFlight();
        System.out.println(cheapestFlight.findCheapestPrice(3, flights, 0, 3, 1));
    }
}
