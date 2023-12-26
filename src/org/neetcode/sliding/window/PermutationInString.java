package org.neetcode.sliding.window;

public class PermutationInString {

    public static boolean checkInclusion(String s1, String s2) {
        int window = s1.length();
        boolean flag = false;
        int l = 0;
        for(int r = window; r <= s2.length(); r++) {
            if(isAnagram(s1,s2.substring(l,r))) {
                return true;
            }
            l++;
        }
        return flag;
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        int[] b = new int[26];
        for(int i = 0; i < s.length(); i++) {
            a[((int) s.charAt(i))-97]++;
        }
        for(int i = 0; i < t.length(); i++) {
            b[((int) t.charAt(i))-97]++;
        }
        for(int i = 0; i< 26; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s1 = "adc", s2 = "dcda";
        System.out.println(checkInclusion(s1,s2));
    }
}
