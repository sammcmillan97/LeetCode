package Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }
        
        for (int num : nums2) {
            if (set1.contains(num)) {
                set1.remove(num);
            }
        }

        for (int num : nums1) {
            if (set2.contains(num)) {
                set2.remove(num);
            }
        }

        List<List<Integer>> differences = new ArrayList<>();
        differences.add(new ArrayList<>(set1));
        differences.add(new ArrayList<>(set2));
        return differences;
    }

    public static void main(String[] args) {
        FindTheDifferenceOfTwoArrays s = new FindTheDifferenceOfTwoArrays();
        int[] nums1 = {1,2,3,3};
        int[] nums2  = {1,1,2,2};

        System.out.println(s.findDifference(nums1, nums2));
    }

}
