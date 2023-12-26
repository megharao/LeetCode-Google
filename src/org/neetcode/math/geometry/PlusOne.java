package org.neetcode.math.geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int[] res = new int[digits.length];
        int carry = 1;
        for(int i = digits.length-1; i >= 0; i--) {
            int sum = digits[i] + carry;
            if(sum > 9) {
                carry = sum / 10;
                sum = sum%10;
                res[i] = sum;
            } else {
                carry = 0;
                res[i] = sum;
            }
        }
        int[] newRes = null;
        if(carry == 1) {
            newRes = new int[digits.length+1];
            newRes[0] = carry;
            for(int i = 0; i < res.length; i++) {
                newRes[i+1] = res[i];
            }
        } else {
            newRes = res;
        }
        return newRes;
    }

    public static void main(String[] args) {
        int[] num = {4,3,2,1};
        PlusOne plusOne = new PlusOne();
        Arrays.stream(plusOne.plusOne(num)).forEach(i->System.out.println(i+" "));
    }
}
