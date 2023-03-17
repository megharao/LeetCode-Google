package org.neetcode.arrays.hashing;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxLength = 0;
        for(int num: nums) {
            int length = 1;
            if(numSet.contains(num-1)) {
                continue;
            } else {
                if(numSet.contains(num+1))
                    length = getLength(num, numSet);
            }
            maxLength = maxLength > length ? maxLength : length;
        }
        return maxLength;
    }

    public int getLength(int num, Set<Integer> numSet) {
        boolean flag = true;
        int length = 1;
        while(flag) {
            if(numSet.contains(num+1)) {
                num = num + 1;
                length++;
            } else {
                flag = false;
            }
        }
        return length;
    }
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        System.out.println(obj.longestConsecutive(nums));
    }
}
