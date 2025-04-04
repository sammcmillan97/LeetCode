import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int numberOfPairs = 0;

        while (i < j) {

            int sum = nums[i] + nums[j];

            if (sum == k) {
                numberOfPairs++;
                i++;
                j--;
            } else if (sum < k) {
                i++;
            } else  {
                j--;
            }
        }
        return numberOfPairs;
    }

    public static void main(String[] args) {
        MaxNumberOfKSumPairs s = new MaxNumberOfKSumPairs();
        int[] nums = {3,1,3,4,3};
        System.out.println(s.maxOperations(nums, 5));
    }
}
