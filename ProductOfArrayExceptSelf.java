class ProductOfArrayExceptSelf {
    
    public int[] solve(int[] nums) {
        int[] pre = new int[nums.length + 1];
        int[] post = new int[nums.length + 1];
        pre[0] = 1;
        post[post.length - 1] = 1;

        for(int i = 1; i < pre.length; i++) {
            pre[i] = nums[i - 1] * pre[i - 1];
        }

        for (int i = post.length - 2; i > 0; i--) {
            post[i] = nums[i] * post[i + 1];
        }
        
        int[] solve = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            solve[i] = pre[i] * post[i + 1];
        }
        return solve;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf s = new ProductOfArrayExceptSelf();
        int[] nums = {-1, 1, 0, -3, 3};
        int[] solution = s.solve(nums);

        for(int num : solution) {
            System.out.println(num);
        }
    }
}
