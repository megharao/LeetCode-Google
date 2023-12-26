package org.neetcode.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabel {
    public List<Integer> partitionLabels(String s) {
        Map<String, Integer> lastIndex = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(String.valueOf(s.charAt(i)),i);
        }
        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(String.valueOf(s.charAt(i))));
            if(i == end) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
