package org.neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int i = 0;
        while(i < s.length() && i+10 <= s.length()) {
            String subs = s.substring(i,i+10);
            if(visited.contains(subs)) {
                res.add(subs);
                visited.remove(subs);
            } else {
                visited.add(subs);
            }
            i++;
        }
        return res.stream().toList();
    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        RepeatedDNASequence repeatedDNASequence = new RepeatedDNASequence();
        System.out.println(repeatedDNASequence.findRepeatedDnaSequences(s));
    }
}
