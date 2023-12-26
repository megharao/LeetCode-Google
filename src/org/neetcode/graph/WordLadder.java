package org.neetcode.graph;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) {
            return 0;
        }
        Map<String, List<String>> dict = new HashMap<>();
        wordList.add(beginWord);
        for(String word: wordList) {
            for(int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0,j) + "*" + word.substring(j+1,word.length());
                if(dict.containsKey(pattern)) {
                    dict.get(pattern).add(word);
                } else {
                    List<String> words = new ArrayList<>();
                    words.add(word);
                    dict.put(pattern,words);
                }
            }
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        ArrayDeque<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        int res = 1;
        while(!queue.isEmpty()) {
            for(int i = 0; i < queue.size(); i++) {
                String word = queue.poll();
                if(word.equals(endWord)) {
                    return res;
                }
                for(int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0,j) + "*" + word.substring(j+1,word.length());
                    for(String neighbor : dict.get(pattern)) {
                        if(!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.addLast(neighbor);
                        }
                    }
                }
            }
            res += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        WordLadder wordLadder = new WordLadder();
        System.out.print(wordLadder.ladderLength(beginWord,endWord,wordList));
    }
}
