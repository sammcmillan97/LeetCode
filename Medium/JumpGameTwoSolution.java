public class JumpGameTwoSolution {

    public int jump(int[] nums) {
        
        if (nums.length == 1) {
            return 0;
        }

        int swaps = 1;
        int currentIndex = 0;
        while(true) {
            if(nums[currentIndex] + currentIndex >= nums.length -1) {
                break;
            }
            currentIndex = findOptimalJump(currentIndex, nums);
            swaps++;
        }
        return swaps;
    }

    private int findOptimalJump(int currentIndex, int[] nums) {

        int endIndex = currentIndex + nums[currentIndex]; //Max current jump
        int bestIndex = 0; //Best possible jump index
        int bestJump = 0; //Best possible jump

        for(int i = 1; (i + currentIndex <= endIndex); i++) {
            int possibleJump = nums[i + currentIndex] - (nums[currentIndex] - i);
            if (possibleJump > bestJump) {
                bestIndex = i + currentIndex;
                bestJump = possibleJump;
            }   
        }
        return bestIndex;
    }

    public static void main(String[] args) {
        JumpGameTwoSolution s = new JumpGameTwoSolution();
        int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int[] nums2 = {2,3,0,1,4};
        System.out.println(s.jump(nums)); //2
        System.out.println(s.jump(nums2)); //2
    }
}
