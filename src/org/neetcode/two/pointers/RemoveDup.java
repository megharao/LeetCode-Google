package org.neetcode.two.pointers;

public class RemoveDup {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        while(r < nums.length) {
            int count = 1;
            while(r+1 < nums.length && nums[r] == nums[r+1]) {
                r++;
                count++;
            }
            for(int i = 0; i < Integer.min(2,count); i++) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,1,2,3,3};
        RemoveDup removeDup = new RemoveDup();
        System.out.println(removeDup.removeDuplicates(nums));
    }
}
