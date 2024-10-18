package org.neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        int zero = 0, one = 0, res = 0;
        Map<Integer, Integer> diffToIndex = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;
            else
                one++;
            if(!diffToIndex.containsKey(one-zero)) {
                diffToIndex.put(one-zero, i);
            }
            if(one == zero) {
                res = one + zero;
            } else {
                int index = diffToIndex.get(one-zero);
                res = Math.max(res, i-index);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
