package org.neetcode.two.pointers;

public class Check2StrArrEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0, w2 = 0; //index of word
        int i=0, j=0; //index of char
        while (w1 < word1.length && w2 < word2.length) {
            if(word1[w1].charAt(i) != word2[w2].charAt(j)) {
                return false;
            }
            i++; j++;
            if(i==word1[w1].length()) {
                w1++;
                i=0;
            }
            if(j==word2[w2].length()) {
                w2++;
                j=0;
            }
        }
        if(w1 != word1.length || w2 != word2.length) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
