package org.neetcode.two.pointers;

public class ReverseString {
    public void reverseString(char[] s) {
        char temp;
        int i = 0, j = s.length-1;
        while(i < j) {
            temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
        System.out.println(s);
    }

    public static void main(String[] args) {
        char[] s = {'H','a','n','n','a','h'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(s);
    }
}
