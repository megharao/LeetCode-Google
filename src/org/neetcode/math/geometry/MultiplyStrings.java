package org.neetcode.math.geometry;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        String zero = "0";
        if(num1.equals(zero) || num2.equals(zero)) {
            return zero;
        }
        Integer[] res = new Integer[num1.length()+num2.length()];
        Arrays.fill(res,0);
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for(int i = 0; i < num1.length(); i++) {
            for(int j = 0; j < num2.length(); j++) {
                int digit = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                res[i+j] += digit;
                res[i+j+1] += digit/10;
                res[i+j] = res[i+j]%10;
            }
        }
        List<Integer> integerList = Arrays.asList(res);
        Collections.reverse(integerList);
        int beg = 0;
        while(beg < res.length && res[beg]==0) {
            beg++;
        }
        StringBuilder strBuilder = new StringBuilder();
        while(beg < res.length) {
            strBuilder.append(res[beg]);
            beg++;
        }
        return strBuilder.toString();
    }

    public static void main(String[] args) {
        String num1 = "123", num2 = "456";
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply(num1,num2));
    }
}
