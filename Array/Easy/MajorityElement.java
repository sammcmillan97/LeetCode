package Array.Easy;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        
        int currentElement = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                currentElement = nums[i];
                count = 1;
            }
             else if (nums[i] == currentElement) {
                count++;
            } else {
                count--;
            }
        }
        return currentElement;
    }

}
