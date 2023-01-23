import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - num;

            if (prevMap.containsKey(diff)) {
                return new int[] { prevMap.get(diff), i };
            }

            prevMap.put(num, i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        int[] nums = {0,4,3,0};
        int target = 0;
        int[] res = twoSum(nums,target);
        System.out.println(res[0]+" "+res[1]);
    }
}
