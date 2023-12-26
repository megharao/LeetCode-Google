package org.neetcode.one.dynamic.programming;

public class LongestPalindrome {
    public String longestPalindrome(String s) {
        String res ="";
        int resLen = 0;
        for(int i = 0; i < s.length(); i++) {
            // odd palindrome
            int left = i, right = i;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if( right - left + 1 > resLen) {
                    res = s.substring(left,right+1);
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }
            // even palindrome
            left = i; right = i+1;
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if( right - left + 1 > resLen) {
                    res = s.substring(left,right+1);
                    resLen = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return res;
    }
}
