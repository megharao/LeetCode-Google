package org.neetcode.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class PartitionString {
    public int partitionString(String s) {
        int count = 0;
        Set<String> visited = new HashSet<>();
        for(char c: s.toCharArray()) {
            if(visited.contains(String.valueOf(c))) {
                count++;
                visited = new HashSet<>();
                visited.add(String.valueOf(c));
            } else {
                visited.add(String.valueOf(c));
            }
        }
        int remaining = visited.size() >0 ? 1 : 0;
        return count+remaining;
    }

    public static void main(String[] args) {
        String s= "ssssss";
        PartitionString partitionString = new PartitionString();
        System.out.println(partitionString.partitionString(s));
    }
}
