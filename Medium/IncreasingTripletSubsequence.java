
public class IncreasingTripletSubsequence {
    // public boolean increasingTriplet(int[] nums) {
    //     if(nums.length < 3) {
    //         return false;
    //     }

    //     int i = 0;
    //     int j = 0;
        
    //     boolean jFound = false;

    //     int returnIndex = 0;
    //     boolean newIFound = true;
    //     int index = 0;

    //     while(newIFound) {
    //         newIFound = false;
    //         jFound = false;
    //         i = returnIndex;
    //         index = i + 1;
    //         if(index == nums.length) {
    //             break;
    //         }

    //         while(index < nums.length) {

    //             if(jFound) {
    //                 if(nums[index] > nums[j]) {
    //                     return true;
    //                 } else {
    //                     if (nums[index] < nums[i]) {
    //                         if(!newIFound && nums[i] != nums[index])  {
    //                             newIFound = true;
    //                             returnIndex = index;
    //                         }
    //                     } else {
    //                         if (nums[j] != nums[index] && nums[i] != nums[index]) {
    //                             j = index;
    //                         }
    //                     }
    //                 }
    //             } else {

    //                 if(nums[index] > nums[i]) {
    //                     jFound = true;
    //                     j = index;
    //                 } else {
    //                     if(!newIFound && nums[i] != nums[index]) {
    //                         newIFound = true;
    //                         returnIndex = index;
    //                     }
    //                 }
    //             }
    //             index++;
    //         }

    //     }
    //     return false; 
    // }
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) {
            return false;
        }

        int i = Integer.MAX_VALUE;
        int j = Integer.MAX_VALUE;
        int index = 0;

        while(index < nums.length) {
            if(nums[index] <= i) {
                i = nums[index];
            } else if (nums[index] <= j) {
                j = nums[index];
            } else {
                return true;
            }
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTripletSubsequence solution = new IncreasingTripletSubsequence();
        int nums[] = {1,2,1,2,1,2,1,2,1,2};
        System.out.println(solution.increasingTriplet(nums));
    }

    
}
