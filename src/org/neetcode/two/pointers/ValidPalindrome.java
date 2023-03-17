package org.neetcode.two.pointers;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        boolean flag = false;
        String cleanedUpStr = s.toLowerCase().replaceAll("[^A-Za-z0-9]","");
        if(cleanedUpStr.isEmpty() || cleanedUpStr.isBlank() || cleanedUpStr.length() == 1) return true;
        int i = 0, j = cleanedUpStr.length()-1;
        while(i < j) {
            if(cleanedUpStr.charAt(i) == cleanedUpStr.charAt(j)) {
                i++;
                j--;
                flag = true;
            } else {
                return false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = " ";
        System.out.println(isPalindrome(s));
    }
}
