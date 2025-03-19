public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int forward[] = new int[nums.length + 1];
        int back[] = new int[nums.length + 1];
        int productExceptSelf[] = new int[nums.length];

        forward[0] = 1;
        for(int i = 1; i < forward.length; i++) {
            forward[i] = forward[i - 1] * nums[i - 1];
        }

        back[back.length - 1] = 1;
        for(int j = back.length - 2; j >= 0; j--) {
            back[j] = back[j + 1] * nums[j];
        }

        for(int k = 0; k < nums.length; k++) {
            productExceptSelf[k] = forward[k] * back[k + 1];
        }

        return productExceptSelf;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
        int nums[] = {1, 2, 3, 4};
        System.out.println(solution.productExceptSelf(nums));
    }
}
