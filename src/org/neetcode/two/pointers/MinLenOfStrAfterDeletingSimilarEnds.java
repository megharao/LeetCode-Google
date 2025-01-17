package org.neetcode.two.pointers;

public class MinLenOfStrAfterDeletingSimilarEnds {
    public static int minimumLength(String s) {
        int l= 0, r = s.length()-1;
        while(l < r && s.charAt(l) == s.charAt(r)) {
            l = nextPrefixPtr(s,l, r);
            r = nextSufffixPtr(s,r, l);
        }
        return r-l+1;
    }

    public static int nextPrefixPtr(String s, int l, int r) {
        char prev = s.charAt(l);
        l++;
        while(l < r && s.charAt(l) == prev) {
            l++;
        }
        return l;
    }

    public static int nextSufffixPtr(String s, int r, int l) {
        char prev = s.charAt(r);
        r--;
        while(r > l && s.charAt(r) == prev) {
            r--;
        }
        return r;
    }

    public static void main(String[] args) {
        String s = "ca";
        System.out.println(minimumLength(s));
    }
}
