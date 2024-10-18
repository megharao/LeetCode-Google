package org.neetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNumInArr {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() != o2.length()) {
                    return o1.length()-o2.length();
                }
                int len = o1.length();
                for(int i = 0; i < len; i++) {
                    if(o1.charAt(i) == o2.charAt(i))
                        continue;
                    return o1.charAt(i)-o2.charAt(i);
                }
                return 0;
            }
        });
        for(String n: nums) {
            pq.add(n);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
