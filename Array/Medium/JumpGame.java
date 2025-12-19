package Array.Medium;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int currentJump = nums[0];
        int currentPostion = 0;


        while(currentPostion < nums.length - 1) {

            if (currentJump < nums[currentPostion]) {
                currentJump = nums[currentPostion];
            }

            if (currentJump == 0) {
                return false;
            }

            currentPostion++;
            currentJump--;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,0,4};
        JumpGame s = new JumpGame();
        System.out.println(s.canJump(nums));
    }
}
