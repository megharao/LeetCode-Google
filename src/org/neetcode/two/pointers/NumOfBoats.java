package org.neetcode.two.pointers;

import java.util.Arrays;

public class NumOfBoats {
    public int numRescueBoats(int[] people, int limit) {
        int count = 0;
        Arrays.sort(people);
        int i = 0, j = people.length-1;
        while( i <= j) {
            if(people[i] + people[j] <= limit) {
                i++;
            }
            j--;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] people = {5,1,4,2};
        NumOfBoats numOfBoats = new NumOfBoats();
        System.out.println(numOfBoats.numRescueBoats(people,6));
    }
}
