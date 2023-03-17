package org.neetcode.two.pointers;

/**
 * Input array is sorted
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        for(int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if(diff >= numbers[i]) {
                for(int j = i +1; j < numbers.length; j++) {
                    if(numbers[j] == diff) {
                        res[0] = i+1;
                        res[1] = j+1;
                        return res;
                    }
                }
            } else {
                return res;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,3,4};
        int target = 0;
        int[] res = twoSum(nums, target);
        System.out.println(res[0] + " " +res[1]);
    }
}
