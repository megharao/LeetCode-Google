package org.neetcode.sliding.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitBaskets {
    public int totalFruit(int[] fruits) {
        int l = 0;
        Map<Integer, Integer> visited = new HashMap<>(); // fruitType->count
        int count = 0;
        int maxFruits = 0;
        for(int r = 0; r < fruits.length; r++) {
            visited.put(fruits[r], visited.getOrDefault(fruits[r],0)+1);
            count++;
            while(visited.size() > 2) {
                int f = fruits[l];
                visited.put(f, visited.get(f)-1);
                count--;
                l++;
                if(visited.get(f) == 0) {
                    visited.remove(f);
                }
            }
            maxFruits = Math.max(maxFruits,count);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        FruitBaskets fruitBaskets = new FruitBaskets();
        System.out.println(fruitBaskets.totalFruit(fruits));
    }
}
