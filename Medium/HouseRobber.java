public class HouseRobber {

    public int rob(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums[0] > nums[1]) {
            nums[1] = nums[0];
        }
        

        for (int i = 2; i < nums.length; i++) {
            int combined = nums[i] + nums[i-2];
            if (combined > nums[i - 1]) {
                nums[i] = combined; 
            } else {
                nums[i] = nums[i - 1];
            }
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums[nums.length - 1];
        } else {
            return nums[nums.length - 2];
        }
    }

    //[1,5,3,1]

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        HouseRobber s = new HouseRobber();
        System.out.println(s.rob(nums));
    }

}
