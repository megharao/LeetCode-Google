package org.neetcode.two.pointers;

public class ReverseWordsInStringII {
    public static String reverseWords(String s) {
        char[] str = s.toCharArray();
        int l = 0;
        for(int r = 0; r < str.length; r++) {
            if(str[r] == ' ' || r == str.length-1) {
                int temp_l = l, temp_r = r-1;
                if(r == str.length-1) {
                    temp_r = r;
                }
                while(temp_l < temp_r) {
                    char temp = str[temp_l];
                    str[temp_l] = str[temp_r];
                    str[temp_r] = temp;
                    temp_l++;
                    temp_r--;
                }
                l = r + 1;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
