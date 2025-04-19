package Easy;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum+= nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum-= nums[i];
            if(rightSum == leftSum) {
                return i;
            }
            leftSum+= nums[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex s = new FindPivotIndex();
        int nums[] = {-1,-1,-1,-1,-1,0};
        System.out.println(s.pivotIndex(nums));
    }
}
