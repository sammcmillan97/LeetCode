package Array.Easy;

public class RemoveDuplicatesFromSortedArray {
    
    public int removeDuplicates(int[] nums) {
        int blankSpotPointer = 1;
        int currentNumber = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == currentNumber) {
                // dont do anything 
            } else {
                currentNumber = nums[i];
                nums[blankSpotPointer] = currentNumber;
                blankSpotPointer++;
            }
        }
        return blankSpotPointer;
    }
}
