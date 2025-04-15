public class LongestSubArrayOf1sAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {

        int longestStreak = 0;
        int currentStreak = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int zeroPoint = i;
                i++;
                while(i < nums.length && nums[i] != 0 ) {
                    currentStreak++;
                    i++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
                i = zeroPoint;
                currentStreak = 0;
            } else {
                currentStreak++;
            }
        }
        longestStreak = Math.max(currentStreak, longestStreak);
        return longestStreak;
    }

    public static void main(String[] args) {
        LongestSubArrayOf1sAfterDeletingOneElement s = new LongestSubArrayOf1sAfterDeletingOneElement();
        int[] nums = {0,1,1,1,0,1,1,0,1};
        System.out.println(s.longestSubarray(nums));
    }
}
