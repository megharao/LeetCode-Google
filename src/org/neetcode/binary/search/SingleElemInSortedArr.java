package org.neetcode.binary.search;

public class SingleElemInSortedArr {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int m = left + (right-left)/2;
            if((m-1 < 0 || nums[m-1] != nums[m]) && (m+1 == nums.length || nums[m] != nums[m+1])) {
                return nums[m];
            }
            int leftSize = (nums[m-1] == nums[m]) ? m-1 : m;
            if(leftSize%2==1) {
                right = m-1;
            } else {
                left = m+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        SingleElemInSortedArr singleElemInSortedArr = new SingleElemInSortedArr();
        System.out.println(singleElemInSortedArr.singleNonDuplicate(nums));
    }
}
