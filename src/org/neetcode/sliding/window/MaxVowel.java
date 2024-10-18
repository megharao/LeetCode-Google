package org.neetcode.sliding.window;

import java.util.Map;

public class MaxVowel {
    public int maxVowels(String s, int k) {
        int l = 0, r= 0;
        int count = 0;
        int res = 0;
        while(r < s.length()) {
            if(r != 0 && (r-l)%k == 0) {
                res = Math.max(res,count);
                if(isVowel(s.charAt(l))) {
                    count--;
                }
                l++;
            } else {
                if(isVowel(s.charAt(r))) {
                    count++;
                }
                r++;
            }
        }
        return Math.max(res,count);
    }

    public boolean isVowel(char c) {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MaxVowel maxVowel = new MaxVowel();
        System.out.println(maxVowel.maxVowels("weallloveyou",7));
    }
}
