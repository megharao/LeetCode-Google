package org.neetcode.greedy;

public class JumpGame {
    public boolean canJump(int[] nums) {
        boolean res = false;
        int goal = nums.length-1;
        for(int i = nums.length-1; i >= 0; i--) {
            if(i+nums[i] >= goal) {
                goal = i;
            }
        }
        if(goal==0)
            return true;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(nums));
    }
}
