public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int[] prod = new int[nums.length];
        int prefix = 1 * nums[0];
        prod[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            prod[i] = prefix;
            prefix = prefix * nums[i];
        }
        int postfix = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            prod[i] = postfix * prod[i];
            postfix = postfix * nums[i];
        }
        return prod;
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] prod = productExceptSelf(nums);
        for (int i = 0; i < prod.length; i++)
            System.out.print(prod[i] + " ");
    }
}
