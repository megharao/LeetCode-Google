package org.neetcode.sliding.window;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            if(window.size() > k) {
                window.remove(nums[l]);
                l++;
            }
            if(window.contains(nums[r])) {
                return true;
            }
            window.add(nums[r]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        System.out.println(containsDuplicateII.containsNearbyDuplicate(nums,2));
    }
}
