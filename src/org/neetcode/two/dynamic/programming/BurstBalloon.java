package org.neetcode.two.dynamic.programming;

import java.util.HashMap;
import java.util.Map;

public class BurstBalloon {

    Map<String, Integer> dp = new HashMap<>();
    int[] nums;
    public int maxCoins(int[] nums) {
        int[] numCopy = new int[nums.length+2];
        numCopy[0] = 1;
        int i = 1;
        for(int n: nums) {
            numCopy[i] = n;
            i++;
        }
        numCopy[i] = 1;
        this.nums = numCopy;

        return dfs(1, numCopy.length-2);
    }

    public int dfs(int l, int r) {
        if(l>r) {
            return 0;
        }
        if(dp.containsKey(l+"#"+r)) {
            return dp.get(l+"#"+r);
        }
        dp.put(l+"#"+r,0);
        for(int i = l; i < r+1; i++) {
            int coins = nums[l-1] * nums[i]*nums[r+1];
            coins += dfs(l,i-1) + dfs(i+1,r);
            dp.put(l+"#"+r, Math.max(dp.get(l+"#"+r),coins));
        }
        return dp.get(l+"#"+r);
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        BurstBalloon burstBalloon = new BurstBalloon();
        System.out.println(burstBalloon.maxCoins(nums));
    }
}
