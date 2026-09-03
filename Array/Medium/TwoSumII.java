package Array.Medium;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        boolean targetNotFound = true;

        while(targetNotFound) {
            int sum = numbers[l] + numbers [r];
            if (sum == target) {
                targetNotFound = true;
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }

        return new int[]{l + 1, r + 1};
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int taget = 9;
        TwoSumII s = new TwoSumII();
        System.out.println(s.twoSum(numbers, taget));
    }

}
