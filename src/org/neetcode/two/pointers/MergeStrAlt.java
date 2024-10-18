package org.neetcode.two.pointers;

public class MergeStrAlt {
    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        String res = "";
        while(i < word1.length() && j < word2.length()) {
            res += String.valueOf(word1.charAt(i)) + String.valueOf(word2.charAt(j));
            i++;
            j++;
        }
        while(i < word1.length()) {
            res += String.valueOf(word1.charAt(i));
            i++;
        }
        while(j < word2.length()) {
            res += String.valueOf(word2.charAt(j));
            j++;
        }
        return res;
    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        MergeStrAlt mergeStrAlt = new MergeStrAlt();
        System.out.println(mergeStrAlt.mergeAlternately(word1,word2));
    }
}
