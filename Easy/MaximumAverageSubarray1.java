package Easy;

public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double slidingAverage = 0;
        for (int i = 0; i < k; i++) {
            slidingAverage+= nums[i];
        }
        double currentBiggest = slidingAverage / k;
        for (int i = 0; i + k< nums.length; i++) {
            slidingAverage-= nums[i];
            slidingAverage+= nums[i + k];
            if (slidingAverage / k > currentBiggest) {
                currentBiggest = slidingAverage / k;
            }
        }
        return currentBiggest;
    }

    public static void main(String[] args) {
        MaximumAverageSubarray1 s = new MaximumAverageSubarray1();
        int[] nums = {1,12,-5,-6,50,3};
        System.out.println(s.findMaxAverage(nums, 4));
    }

}
