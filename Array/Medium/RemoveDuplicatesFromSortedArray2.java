package Array.Medium;

public class RemoveDuplicatesFromSortedArray2 {
    
    public int removeDuplicates(int[] nums) {
        int currentInt = nums[0];
        int pointer = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentInt && count < 2) {
                nums[pointer] = nums[i];
                pointer++;
                count++;
            } else if (nums[i] != currentInt) {
                nums[pointer] = nums[i];
                pointer++;

                currentInt = nums[i];
                count = 1;
            } else {
                //This is the case when the number exceeds the count of 2, do nothing
            }
        }
        
        return pointer;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        RemoveDuplicatesFromSortedArray2 s = new RemoveDuplicatesFromSortedArray2();
        int count = s.removeDuplicates(nums);
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
    }
}
