package org.neetcode.arrays.hashing;

public class SortColours {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            while(count[j] > 0) {
                nums[i] = j;
                i++;
                count[j]--;
            }
            i--;
            j++;
        }
        System.out.println(nums);
    }

    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        SortColours sortColours = new SortColours();
        sortColours.sortColors(nums);
    }
}
