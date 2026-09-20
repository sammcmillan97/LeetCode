package SlidingWindow.Medium;

public class MinimumSizeSubarraySum {
    
    
    public int minSubArrayLen(int target, int[] nums) {
        int rollingSum = nums[0];
        int rollingTotalInts = 1;
        int currentShortest = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;

        while(l < nums.length) {
            if (r >= nums.length) {
                if (rollingSum >= target) {
                    if (rollingTotalInts < currentShortest) {
                        currentShortest = rollingTotalInts;
                    } 
                    rollingSum-= nums[l];
                    rollingTotalInts--;
                    l++;
                } else {
                    if (currentShortest == Integer.MAX_VALUE) {
                        return 0;
                    } else {
                        return currentShortest;
                    }
                }

            } else {
                //If bigger or equal to current target
                if (rollingSum >= target) {

                    if (rollingTotalInts < currentShortest) {
                        currentShortest = rollingTotalInts;
                    } 

                    if (l == r) {
                        return 1;
                    }

                    //make number smaller by increasing l
                    rollingSum-= nums[l];
                    rollingTotalInts--;
                    l++;
                   
                //Less then current target    
                } else {
                    r++;
                    if (r < nums.length) {
                        rollingSum+= nums[r];
                        rollingTotalInts++;
                    } 
                }
            }
        }
        if (currentShortest == Integer.MAX_VALUE) {
            return 0;
        } else {
            return currentShortest;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        MinimumSizeSubarraySum s = new MinimumSizeSubarraySum();
        System.out.println(s.minSubArrayLen(7, nums));
    }

}
