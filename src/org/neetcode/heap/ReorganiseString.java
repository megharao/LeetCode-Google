package org.neetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganiseString {
    public String reorganizeString(String s) {
        Comparator<Pair> comparator = Comparator.comparingInt(a->a.count);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(comparator.reversed());
        Map<Character, Integer> counter = new HashMap<>();
        for(char c: s.toCharArray()) {
            if(!counter.containsKey(c)) {
                counter.put(c,0);
            }
            int co = counter.get(c);
            counter.put(c,co+1);
        }
        for(Map.Entry<Character,Integer> entry:counter.entrySet()) {
            maxHeap.add(new Pair(entry.getValue(), entry.getKey()));
        }
        Pair prev = null;
        String res = "";
        while(!maxHeap.isEmpty() || prev != null) {
            if(prev != null && maxHeap.isEmpty()) {
                return "";
            }
            Pair pair = maxHeap.poll();
            res += pair.c;
            pair.count--;
            if(prev != null) {
                maxHeap.add(prev);
                prev = null;
            }
            if(pair.count != 0)
                prev = pair;
        }
        return res;
    }

    class Pair{
        int count;
        char c;
        Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
}
