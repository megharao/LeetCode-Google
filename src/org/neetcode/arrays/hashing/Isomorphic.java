package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        int map1[]=new int[200];
        int map2[]=new int[200];

        if(s.length() != t.length()) {
            return false;
        }
        for(int i = 0; i < s.length(); i++) {
            if(map1[s.charAt(i)]!=map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)]=i+1;
            map2[t.charAt(i)]=i+1;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "paper", t = "title";
        Isomorphic isomorphic = new Isomorphic();
        System.out.println(isomorphic.isIsomorphic(s,t));
    }
}
