package org.neetcode.arrays.hashing;

public class LargestThreeSameNum {
    public String largestGoodInteger(String num) {
        String res = "";
        if(num.length() == 3) {
            if(isGood(num)) {
                return num;
            }
        }
        for(int i = 0; i < num.length()-2; i++) {
            String substring = num.substring(i, i + 3);
            if(isGood(substring)) {
                if(res.isEmpty() || Integer.valueOf(res) < Integer.valueOf(substring)) {
                    res = substring;
                }
            }
        }
        return res;
    }

    public boolean isGood(String str) {
        for(int i = 0; i < str.length()-1; i++) {
            if(str.charAt(i) != str.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String num = "1221000";
        LargestThreeSameNum largestThreeSameNum = new LargestThreeSameNum();
        System.out.println(largestThreeSameNum.largestGoodInteger(num));
    }
}
