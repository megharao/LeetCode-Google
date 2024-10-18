package org.neetcode.binary.search;

public class SortedSq {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int right = nums.length-1;
        int left = 0;
        int resultIndex = res.length-1;
        while(left <= right) {
            if(nums[left]*nums[left] >= nums[right]*nums[right]) {
                res[resultIndex] = nums[left]*nums[left];
                left++;
            } else {
                res[resultIndex] = nums[right]*nums[right];
                right--;
            }
            resultIndex--;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
