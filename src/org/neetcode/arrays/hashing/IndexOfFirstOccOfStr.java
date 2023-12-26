package org.neetcode.arrays.hashing;

public class IndexOfFirstOccOfStr {
    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++) {
            if(i+needle.length() <= haystack.length() && needle.equals(haystack.substring(i,i+needle.length()))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "leetcode", needle = "leeto";
        IndexOfFirstOccOfStr index = new IndexOfFirstOccOfStr();
        System.out.println(index.strStr(haystack,needle));
    }
}
