package org.neetcode.binary.search;

public class Sqrt {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        int mid = 0;
        int probableAns = 0;
        while(left<=right) {
            mid = (left+right)/2;
            if((long)mid*mid<=(long)x) {
                probableAns = mid;
                left = mid+1;
            } else if((long)mid*mid > (long)x) {
                right = mid-1;
            }
        }
        return probableAns;
    }
}
