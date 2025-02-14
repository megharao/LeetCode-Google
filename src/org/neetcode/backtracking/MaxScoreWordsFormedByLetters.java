package org.neetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

public class MaxScoreWordsFormedByLetters {

    Map<Character, Integer> charToScore = new HashMap<>();
    Map<Character, Integer> letterToCount = new HashMap<>();
    String[] words;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        for(int i = 0; i < score.length; i++) {
            Character c = (char) ('a' + i);
            charToScore.put(c, score[i]);
        }
        for(int i = 0; i < letters.length; i++) {
            letterToCount.put(letters[i], letterToCount.getOrDefault(letters[i], 0)+1);
        }
        return dfs(0);
    }

    public int dfs(int i) {
        if(i==words.length) {
            return 0;
        }
        //skip the word
        int res = dfs(i+1);
        //include the word
        if(canFormWord(words[i])) {
            for(char c: words[i].toCharArray()) {
                letterToCount.put(c, letterToCount.get(c)-1);
            }
            res = Math.max(res, getScore(words[i]) + dfs(i+1));
            for(char c: words[i].toCharArray()) {
                letterToCount.put(c, letterToCount.get(c)+1);
            }
        }
        return res;
    }

    public int getScore(String word) {
        int score = 0;
        for(char c : word.toCharArray()) {
            score += charToScore.get(c);
        }
        return score;
    }

    public boolean canFormWord(String word) {
        Map<Character, Integer> wordCount = new HashMap<>();
        for(char c: word.toCharArray()) {
            wordCount.put(c, wordCount.getOrDefault(c, 0)+1);
        }
        for(Map.Entry<Character, Integer> entry: wordCount.entrySet()) {
            if(entry.getValue() > letterToCount.getOrDefault(entry.getKey(),0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
        MaxScoreWordsFormedByLetters m = new MaxScoreWordsFormedByLetters();
        m.maxScoreWords(words, letters, score);
    }
}
