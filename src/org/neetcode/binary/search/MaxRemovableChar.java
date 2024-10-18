package org.neetcode.binary.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class MaxRemovableChar {
    public int maximumRemovals(String s, String p, int[] removable) {
        Set<Integer> removed = new HashSet<>();
        int res = 0;
        int l = 0, r = removable.length-1;
         while(l <= r) {
             int m = l + (r-l)/2;
             removed = Arrays.stream(Arrays.copyOfRange(removable,0,m+1)).boxed().collect(Collectors.toSet());
             if(isSubSeq(s,p,removed)) {
                 res = Math.max(res, m+1);
                 l = m+1;
             } else {
                 r = m-1;
             }
         }
         return res;
    }

    public boolean isSubSeq(String s, String p, Set<Integer> removed) {
        int i1 = 0, i2 = 0;
        while(i1 < s.length() && i2 < p.length()) {
            if(removed.contains(i1) || s.charAt(i1) != p.charAt(i2)) {
                i1++;
                continue;
            }
            i1++;
            i2++;
        }
        return i2 == p.length();
    }
}
