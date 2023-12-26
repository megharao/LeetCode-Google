package org.neetcode.binary.search;

public class SearchRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        int index = -1;
        while(l<=r) {
                int mid = l + (r-l)/2;
                if(nums[mid] == target) {
                    index = mid;
                    break;
                }
                //left sorted portion
                else if(nums[l] <= nums[mid]) {
                    if(target > nums[mid] || target < nums[l]) {
                        l = mid+1;
                    } else {
                        r = mid-1;
                    }
                }
                //right sorted portion
                else {
                    if(target < nums[mid] || target > nums[r]) {
                        r = mid-1;
                    } else {
                        l = mid+1;
                    }
                }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
}
