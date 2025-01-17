package org.neetcode.two.pointers;

import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gI = 0, sI = 0;
        while(gI < g.length && sI < s.length) {
            if(s[sI] >= g[gI]) {
                sI++;
                gI++;
            } else {
                sI++;
            }
        }
        return gI;
    }

    public static void main(String[] args) {
        int[] g = {1,2,3}, s = {1,1};
        System.out.println(findContentChildren(g,s));
    }
}
