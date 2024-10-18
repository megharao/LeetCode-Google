package org.neetcode.binary.search;

public class SearchInsertPos {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length;
        while(low < high) {
            int mid = (low+high)/2;
            if(target > nums[mid]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        SearchInsertPos searchInsertPos = new SearchInsertPos();
        System.out.println(searchInsertPos.searchInsert(nums,2));
    }
}
