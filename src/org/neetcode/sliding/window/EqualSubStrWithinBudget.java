package org.neetcode.sliding.window;

public class EqualSubStrWithinBudget {
    public static int equalSubstring(String s, String t, int maxCost) {
        int currCost = 0, l = 0, maxLen = 0;
        for(int r = 0; r < s.length(); r++) {
            currCost += Math.abs(s.charAt(r) - t.charAt(r));
            while(currCost > maxCost) {
                currCost -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            }
            maxLen = Math.max(maxLen, r-l+1);

        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcd", t = "bcdf";
        int maxCost = 3;
        System.out.println(equalSubstring(s,t,maxCost));
    }
}
