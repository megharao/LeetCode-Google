package org.neetcode.sliding.window;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSubArrWhereMaxElemAppearsAtleastKTimes {
    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int l = 0;
        int res = 0;
        long count = 0;
        for(int r = 0; r < nums.length; r++) {
            if(nums[r] == max) {
                count++;
            }
            while(count > k || (l <= r && count ==k && nums[l] != max)) {
                if(nums[l] == max) {
                    count--;
                }
                l++;
            }
            if(count == k) {
                res += l+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
