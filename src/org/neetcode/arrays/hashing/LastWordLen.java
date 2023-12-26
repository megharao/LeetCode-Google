package org.neetcode.arrays.hashing;

public class LastWordLen {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length-1].length();
    }

    public static void main(String[] args) {

    }
}
