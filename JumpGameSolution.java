public class JumpGameSolution {
    public boolean canJump(int[] nums) {
        int currentJump = nums[0];
        if (currentJump == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        for(int i = 1; i < nums.length - 1; i++) {
            currentJump--;
            if(currentJump < nums[i]) {
                currentJump = nums[i];
            } else if (currentJump <= 0) {
                return false;
            }
        }
        return true;
    }

    // public static void main(String[] args) {
    //     JumpGameSolution s = new JumpGameSolution();
    //     int[] nums = {2, 3, 1, 1, 4};
    //     int[] nums2 = {3, 2, 1, 0, 4};
    //     System.out.println(s.canJump(nums)); //true
    //     System.out.println(s.canJump(nums2)); //false
    // }
}
