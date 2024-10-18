package org.neetcode.binary.search;

public class SearchRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(nums[m] == target) {
                return true;
            }
            if(nums[l] < nums[m]) {
                //left portion
                if(nums[l] <= target && target < nums[m]) {
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else if(nums[l] > nums[m]) {
                //right portion
                if(nums[m] < target && target <= nums[r]) {
                    l = m+1;
                } else {
                    r = m-1;
                }
            } else {
                //unable to determine if we are in left portion or right portion
                l++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1,1};
        SearchRotatedSortedArrayII searchRotatedSortedArrayII = new SearchRotatedSortedArrayII();
        System.out.println(searchRotatedSortedArrayII.search(nums,0));
    }
}
