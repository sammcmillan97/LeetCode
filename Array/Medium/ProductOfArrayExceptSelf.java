package Array.Medium;

public class ProductOfArrayExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length + 2];
        int[] rightProduct = new int[nums.length + 2];
        
        leftProduct[0]  = 1;
        leftProduct[leftProduct.length - 1] = 1;
        
        for(int i = 0; i < leftProduct.length - 2; i++) {
            leftProduct[i + 1] = leftProduct[i] * nums[i];
        }

        rightProduct[0] = 1;
        rightProduct[rightProduct.length - 1] = 1;

        for(int i = nums.length; i > 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i - 1];
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = leftProduct[i] * rightProduct[i + 2];
        }

        return rightProduct;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();
        int[] nums = {1,2,3,4};
        System.out.println(s.productExceptSelf(nums));
    }

}
