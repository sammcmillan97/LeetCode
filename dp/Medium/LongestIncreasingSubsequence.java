package dp.Medium;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        dp[dp.length - 1] = 1;
        int currentLongest = 1;

        for(int i = nums.length - 2; i >= 0; i--) {
            
            int currentMaximum = 1;

            for(int j = i + 1; j < nums.length; j++) {
                
                if (nums[i] < nums[j] && (currentMaximum < dp[j] + 1)) {
                    currentMaximum = dp[j] + 1;
                }
            }
            if (currentLongest < currentMaximum) {
                currentLongest = currentMaximum;
            }
            dp[i] = currentMaximum;
        }

        return currentLongest;
    }

    public static void main(String[] args) {

        int[] nums = {0,1,0,3,2,3};
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        System.out.println(s.lengthOfLIS(nums));
    }
}
