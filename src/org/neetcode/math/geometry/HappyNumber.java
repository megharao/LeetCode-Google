package org.neetcode.math.geometry;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        while(visited.add(n)) {
            int total = getSum(n);
            if(total == 1) {
                return true;
            } else {
                n = total;
            }
        }
        return false;
    }

    public int getSum(int n) {
        int sum = 0;
        while(n > 9) {
            int digit = n % 10;
            n = n /10;
            sum += digit*digit;
        }
        sum += n*n;
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(1111111));
    }
}
