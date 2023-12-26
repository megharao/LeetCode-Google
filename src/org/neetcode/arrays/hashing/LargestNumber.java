package org.neetcode.arrays.hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        List<String> digits = Arrays.stream(nums)
                .mapToObj(num -> String.valueOf(num)).collect(Collectors.toList());
        digits.sort((a,b) -> (b+a).compareTo(a+b));
        String res = digits.stream().reduce("",String::concat);
        return res.startsWith("0") ? "0" : res;
    }

    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(nums));
    }
}
