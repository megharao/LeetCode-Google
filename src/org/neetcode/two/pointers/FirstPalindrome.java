package org.neetcode.two.pointers;

public class FirstPalindrome {
    public static String firstPalindrome(String[] words) {
        for(String w: words) {
            if(isPalindrome(w)) {
                return w;
            }
        }
        return "";
    }

    public static boolean isPalindrome(String w) {
        int i = 0, j = w.length()-1;
        while(i <= j) {
            if(w.charAt(i) != w.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"def","ghi"};
        System.out.println(firstPalindrome(words));
    }
}
