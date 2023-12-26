package org.neetcode.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

public class StringBinaryCodes {
    public boolean hasAllCodes(String s, int k) {
        double count = Math.pow(2,k);
        Set<String> codes = new HashSet<>();
        int i = 0;
        while(i+k <= s.length()) {
            codes.add(s.substring(i,i+k));
            i++;
        }
        return codes.size() == count;
    }

    public static void main(String[] args) {
        String s = "00110";
        StringBinaryCodes stringBinaryCodes = new StringBinaryCodes();
        System.out.println(stringBinaryCodes.hasAllCodes(s,2));
    }
}
