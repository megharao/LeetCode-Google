import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> duplicates = new HashMap<>();
        for(int n: nums) {
            if(duplicates.containsKey(n)) {
                return true;
            }
            duplicates.put(n,0);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
}