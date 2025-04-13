import java.util.Deque;
import java.util.LinkedList;

public class MaxConsecutiveOne3 {
    public int longestOnes(int[] nums, int k) {
        Deque<Integer> flipped = new LinkedList<>();
        int startingPoint = 0;
        int currentLongest = 0;
        for(int i = 0; i < nums.length ;i++) {
            int currentLength = 0;
            if (nums[i] == 0) {
                flipped.add(i);
            }
            if (flipped.size() > k) {
                startingPoint = flipped.remove() + 1;
            }


            currentLength = i - startingPoint + 1;

            if (currentLength > currentLongest) {
                currentLongest = currentLength;
            }
        }
        return currentLongest;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k = 3;
        MaxConsecutiveOne3 s = new MaxConsecutiveOne3();
        System.out.println(s.longestOnes(nums, k));
    }

}
