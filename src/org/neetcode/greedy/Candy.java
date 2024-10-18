package org.neetcode.greedy;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        int prevRating = 0, prevCandies = 0;
        for(int i = 0; i < ratings.length; i++) {
            if(ratings[i] > prevRating) {
                candies[i] = 1 + prevCandies;
            } else {
                candies[i] = 1;
            }
            prevRating = ratings[i];
            prevCandies = candies[i];
        }
        prevRating = ratings[ratings.length-1]; prevCandies = candies[candies.length-1];
        for(int i = ratings.length-2; i >= 0; i--) {
            if(ratings[i] > prevRating && candies[i] <= prevCandies) {
                candies[i] = 1 + prevCandies;
            }
            prevRating = ratings[i];
            prevCandies = candies[i];
        }
        return Arrays.stream(candies).sum();
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        Candy candy = new Candy();
        System.out.println(candy.candy(ratings));
    }
}
