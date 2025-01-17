package org.neetcode.two.pointers;

public class MinTimeForColorfulBalloons {
    public static int minCost(String colors, int[] neededTime) {
        int cost = 0;
        int i = 0, j = 1;
        while(j < neededTime.length && i < neededTime.length) {
            if(colors.charAt(i) != colors.charAt(j)) {
                i=j;
                j++;
            } else {
                if(neededTime[i] < neededTime[j]) {
                    cost += neededTime[i];
                    i = j;
                    j++;
                } else {
                    cost += neededTime[j];
                    j++;
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        String colors = "cddcdcae";
        int[] neededTime = {4,8,8,4,4,5,4,2};
        System.out.println(minCost(colors, neededTime));
    }
}
