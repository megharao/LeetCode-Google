package org.neetcode.binary.search;

public class FindPeakElem {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length-1;
        while(l <= r) {
            int m = l + (r-l)/2;
            //is left neighbour greater
            if(m > 0 && nums[m] < nums[m-1]) {
                r = m-1;
            }
            //is right neighbour greater
            else if(m < nums.length-1 && nums[m] < nums[m+1]) {
                l = m+1;
            } else {
                return m;
            }
        }
        return -1;
    }


}
