package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxBalloons {
    public int maxNumberOfBalloons(String text) {
        Map<String, Integer> balloon = new HashMap<>();
        int count = 0;
        for(char c: text.toCharArray()) {
           if(c=='b' || c == 'a' || c == 'l' || c == 'o' || c == 'n') {
               balloon.put(String.valueOf(c),balloon.getOrDefault(String.valueOf(c),0)+1);
           }
        }
        boolean flag = true;
        while(flag) {
            if(isValid(balloon)) {
                count++;
                balloon.put("b",balloon.get("b")-1);
                balloon.put("a",balloon.get("a")-1);
                balloon.put("l",balloon.get("l")-2);
                balloon.put("o",balloon.get("o")-2);
                balloon.put("n",balloon.get("n")-1);
            } else {
                flag = false;
            }
        }
        return count;
    }

    public boolean isValid(Map<String,Integer> balloon) {
        return balloon.containsKey("b")
                && balloon.get("b")-1 >= 0
                && balloon.containsKey("a")
                && balloon.get("a")-1 >= 0
                && balloon.containsKey("l")
                && balloon.get("l")-2 >= 0
                && balloon.containsKey("o")
                && balloon.get("o")-2 >= 0
                && balloon.containsKey("n")
                && balloon.get("n")-1 >= 0;
    }

    public static void main(String[] args) {
        String text = "nlaebolko";
        MaxBalloons maxBalloons = new MaxBalloons();
        System.out.println(maxBalloons.maxNumberOfBalloons(text));
    }
}
