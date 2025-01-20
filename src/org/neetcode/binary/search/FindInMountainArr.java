package org.neetcode.binary.search;

public class FindInMountainArr {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        //Find Peak
        int l = 1, r = len-2, peak = 0;
        while(l <= r) {
            int m = (l+r)/2;
            int left = mountainArr.get(m-1);
            int mid = mountainArr.get(m);
            int right = mountainArr.get(m+1);
            if(left < mid && mid < right) {
                l = m+1;
            } else if (left > mid && mid > right) {
                r = m-1;
            } else {
                peak = m;
                break;
            }
        }
        //search left portion
        l = 0;
        r = peak-1;
        while(l <= r) {
            int m = (l+r)/2;
            int val = mountainArr.get(m);
            if(val < target) {
                l = m+1;
            } else if(val > target) {
                r = m-1;
            } else {
                return m;
            }
        }
        //search right portion
        l = peak;
        r = len-1;
        while (l <= r) {
            int m = (l+r)/2;
            int val = mountainArr.get(m);
            if(val<target) {
                r = m-1;
            } else if(val > target) {
                l = m+1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}

interface MountainArray {
    public int get(int index);

    public int length();
}
