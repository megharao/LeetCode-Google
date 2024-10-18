package org.neetcode.sliding.window;

public class MinFlips {
    public int minFlips(String s) {
        int len = s.length();
        s = s+s;
        String alt1 = "", alt2 = "";
        for(int i = 0; i < s.length(); i++) {
            if(i%2 == 0) {
                alt1 += "0";
                alt2 += "1";
            } else {
                alt1 += "1";
                alt2 += "0";
            }
        }
        int res = s.length();
        int diff1 = 0, diff2 = 0;
        int l = 0;
        for(int r = 0; r < s.length(); r++) {
            if(s.charAt(r) != alt1.charAt(r)) {
                diff1++;
            }
            if(s.charAt(r) != alt2.charAt(r)) {
                diff2++;
            }
            if(r-l+1 > len) {
                if(s.charAt(l) != alt1.charAt(l)) {
                    diff1--;
                }
                if(s.charAt(l) != alt2.charAt(l)) {
                    diff2--;
                }
                l++;
            }
            if(r-l+1 == len) {
                res = Math.min(res, Math.min(diff1,diff2));
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
