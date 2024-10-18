package org.neetcode.backtracking;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class UniqueBinaryString {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> strSet = Arrays.stream(nums).collect(Collectors.toSet());
        String[] str = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            str[i] = "0";
        }
        return backtrack(0,str,nums, strSet);
    }

    public String backtrack(int i, String[] currStr, String[] nums, Set<String> strSet) {
        if(i==nums.length) {
            String val = String.join("",currStr);
            return strSet.contains(val) ? null : val;
        }
        String res = backtrack(i+1,currStr,nums,strSet);
        if(res != null) {
            return res;
        }
        currStr[i] = "1";
        res = backtrack(i+1,currStr,nums,strSet);
        if(res != null) {
            return res;
        }
        return null;
    }
}
