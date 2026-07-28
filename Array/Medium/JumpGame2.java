package Array.Medium;

public class JumpGame2 {

    public int jump(int[] nums) {
        if (nums.length==1) return 0;
        int currentJump = nums[0];
        int currentPostion = 0;
        int numberOfJumps = 1;


        while(currentJump + currentPostion < nums.length - 1) {
            int indexOfCandidate = 0;
            int candidate = 0;

            for(int i = currentPostion + 1; i <= currentPostion + currentJump; i++) {
                if (nums[i] + i  > candidate) {
                    candidate = nums[i] + i;
                    indexOfCandidate = i;
                }
            }

            numberOfJumps++;
            currentPostion = indexOfCandidate;
            currentJump = nums[indexOfCandidate];

        }
        return numberOfJumps;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        JumpGame2 s = new JumpGame2();
        System.out.println(s.jump(nums));
    }
}
