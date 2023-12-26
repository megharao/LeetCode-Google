package org.neetcode.arrays.hashing;

public class IsSubseq {
    public boolean isSubsequence(String s, String t) {
        int sPtr = 0, tPtr = 0;
        while(sPtr < s.length() && tPtr < t.length()) {
            if(s.charAt(sPtr) == t.charAt(tPtr)) {
                sPtr++;
                tPtr++;
            } else {
                tPtr++;
            }
        }
        return sPtr == s.length();
    }

    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        IsSubseq subseq = new IsSubseq();
        System.out.println(subseq.isSubsequence(s,t));
    }
}
