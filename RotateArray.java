class RotateArraySolution {
    public void rotate(int[] nums, int k) {
        int[] nums2  = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int index = (k + i) % nums.length;
            nums2[index] = nums[i];  
        }

        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        RotateArraySolution s = new RotateArraySolution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        s.rotate(nums, 3);
        for(int num : nums) {
            System.out.println(num);
        }
    }
}