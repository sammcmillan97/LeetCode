import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;

public class MaximumSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int[][] numsJoined = new int[nums1.length][2];

        for(int i = 0; i < nums1.length; i++) {
            numsJoined[i][0] = nums1[i];
            numsJoined[i][1] = nums2[i];
        }

        Arrays.sort(numsJoined, Comparator.comparingInt((int[] a ) -> a[1]).reversed());
        // for (int[] sub : numsJoined) {
        //     System.out.println(String.format("%d:%d", sub[0], sub[1]));
        // }
        int max = 0;
        int runningSum = 0;
        PriorityQueue<Integer> nextSmallest = new PriorityQueue<>();

        for(int i = 0; i < k; i++) {
            runningSum +=  numsJoined[i][0];
            nextSmallest.add(numsJoined[i][0]);
        }
        max = runningSum * numsJoined[k - 1][1];
        System.out.println(max);

        for(int i = k; i < nums1.length; i++) {
            runningSum +=  numsJoined[i][0];
            runningSum -= nextSmallest.poll();
            nextSmallest.add(numsJoined[i][0]);

            if (runningSum * numsJoined[i][1] > max) {
                max = runningSum * numsJoined[i][1];
            }
        }


        return max;
    }

    public static void main(String args[]) {
        MaximumSubsequenceScore s = new MaximumSubsequenceScore();
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        System.out.println(s.maxScore(nums1, nums2, 3));
    }   

}
