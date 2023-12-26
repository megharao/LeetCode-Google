package org.neetcode.arrays.hashing;

public class SignOfProdArray {
    public int arraySign(int[] nums) {
        boolean isNegative = false;
        for(int n: nums) {
            if(n < 0) {
                isNegative = !isNegative;
            } else if(n == 0) {
                return 0;
            }
        }
        if(isNegative) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {9,72,34,29,-49,-22,-77,-17,-66,-75,-44,-30,-24};
        SignOfProdArray signOfProdArray = new SignOfProdArray();
        System.out.println(signOfProdArray.arraySign(nums));
    }
}
