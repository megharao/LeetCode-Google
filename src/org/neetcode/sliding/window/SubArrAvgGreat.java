package org.neetcode.sliding.window;

public class SubArrAvgGreat {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int len = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(len == k ) {
                if((sum / k) >= threshold) {
                    count++;
                }
                sum = sum - arr[i-k] + arr[i];
            } else {
                len++;
                sum += arr[i];
            }
        }
        if(len == k ) {
            if ((sum / k) >= threshold) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {11,13,17,23,29,31,7,5,2,3};
        SubArrAvgGreat subArrAvgGreat = new SubArrAvgGreat();
        System.out.println(subArrAvgGreat.numOfSubarrays(arr,3,5));
    }
}
