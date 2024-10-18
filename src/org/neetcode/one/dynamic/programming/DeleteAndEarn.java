package org.neetcode.one.dynamic.programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
        public int deleteAndEarn(int[] nums) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                countMap.put(nums[i],countMap.getOrDefault(nums[i],0)+1);
            }
            Arrays.sort(nums);
            nums = Arrays.stream(nums).distinct().toArray();
            int earn1 = 0, earn2 = 0;
            for(int i = 0; i < nums.length;i++) {
                int currEarn = nums[i]*countMap.get(nums[i]);
                //first case we can't use earn1 and earn2
                if(i > 0 && nums[i] == nums[i-1]+1) {
                    int temp = earn2;
                    earn2 = Math.max(currEarn+earn1, earn2);
                    earn1 = temp;
                } else {
                    int temp = earn2;
                    earn2 = currEarn+earn2;
                    earn1 = temp;
                }
            }
            return earn2;
        }
}
