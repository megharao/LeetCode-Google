package org.neetcode.two.pointers;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        boolean chanceTaken = false;
        while(i < j) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else if(!chanceTaken) {
                String sub1 = s.substring(i,j);
                String sub2 = s.substring(i+1,j+1);
                chanceTaken = true;
                if(sub1.equals(new StringBuilder(sub1).reverse().toString())) {
                    j--;
                }else if(sub2.equals(new StringBuilder(sub2).reverse().toString())) {
                    i++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ebcbbcecabbacecbbcbe";
        ValidPalindromeII validPalindromeII = new ValidPalindromeII();
        System.out.println(validPalindromeII.validPalindrome(s));
    }
}
