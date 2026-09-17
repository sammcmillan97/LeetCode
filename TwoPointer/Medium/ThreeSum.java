package TwoPointer.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSum {
    
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {

                Set<Integer> secondInteger = new HashSet<>();
                int l = i + 1;
                int r = nums.length -1;

                while(l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if(sum == 0) {
                        if(!secondInteger.contains(nums[l])) {
                            results.add(List.of(nums[i], nums[l], nums[r]));
                            secondInteger.add(nums[l]);
                        }
                        l++;
                        r--;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSum s = new ThreeSum();
        List<List<Integer>> result = s.threeSum(nums);
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i).stream()
                               .map(String::valueOf) // Convert Integer to String
                               .collect(Collectors.joining(", ")));
        }
    }

}
