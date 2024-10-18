package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LongestHappyString {
    public String longestDiverseString(int a, int b, int c) {
        Comparator<Pair> pairComparator = Comparator.comparingInt(p->p.count);
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(pairComparator.reversed());
        if( a != 0) maxHeap.add(new Pair(a,'a'));
        if( b != 0) maxHeap.add(new Pair(b,'b'));
        if( c != 0) maxHeap.add(new Pair(c,'c'));
        String res = "";
        while(!maxHeap.isEmpty()) {
            Pair curr = maxHeap.poll();
            if(res.length() > 1 && res.charAt(res.length()-2) == res.charAt(res.length()-1) && res.charAt(res.length()-1) == curr.c) {
                if(maxHeap.isEmpty()) {
                    break;
                }
                Pair currNext = maxHeap.poll();
                res += currNext.c;
                currNext.count--;
                if(currNext.count != 0) {
                    maxHeap.add(currNext);
                }
            } else {
                res += curr.c;
                curr.count--;
            }
            if(curr.count != 0) {
                maxHeap.add(curr);
            }
        }
        return res;
    }

    class Pair {
        int count;
        char c;
        Pair(int count, char c) {
            this.count = count;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longestDiverseString(1,1,7));
    }
}
