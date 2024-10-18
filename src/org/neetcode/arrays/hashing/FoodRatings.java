package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {

    private Map<String, Integer> foodRatingMap;
    private Map<String, String> foodCusineMap;
    private Map<String, PriorityQueue<Food>> cusineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCusineMap = new HashMap<>();
        cusineFoodMap = new HashMap<>();
        for(int i = 0; i < foods.length; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCusineMap.put(foods[i], cuisines[i]);
            cusineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        String cusine = foodCusineMap.get(food);
        cusineFoodMap.get(cusine).add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        Food food = cusineFoodMap.get(cuisine).peek();
        while(foodRatingMap.get(food.foodName) != food.foodRating) {
            cusineFoodMap.get(cuisine).poll();
            food = cusineFoodMap.get(cuisine).peek();
        }
        return food.foodName;
    }
}

class Food implements Comparable<Food>{

    int foodRating;

    String foodName;

    public Food(int foodRating, String foodName) {
        this.foodRating = foodRating;
        this.foodName = foodName;
    }

    @Override
    public int compareTo(Food o) {
        if(foodRating == o.foodRating) {
            return foodName.compareTo(o.foodName);
        }
        return -1 * Integer.compare(foodRating, o.foodRating);
    }
}
