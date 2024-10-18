package org.neetcode.one.dynamic.programming;

import java.util.Arrays;

public class NumOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        int[] count = new int[nums.length];
        int lenLIS = 0, res = 0;
        Arrays.fill(lis,1);
        for(int i = nums.length-1; i >= 0; i--) {
            int maxLen = 1, maxCount = 1;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    int length = lis[j];
                    int counter = count[j];
                    if(length+1 > maxLen) {
                        maxLen = length+1;
                        maxCount = counter;
                    } else if(length+1 == maxLen) {
                        maxCount += counter;
                    }
                }
            }
            if(maxLen > lenLIS) {
                lenLIS = maxLen;
                res = maxCount;
            } else if(maxLen == lenLIS) {
                res += maxCount;
            }
            lis[i] = maxLen;
            count[i] = maxCount;
        }
        return res;
    }
}
