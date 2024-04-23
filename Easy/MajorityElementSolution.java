package Easy;

public class MajorityElementSolution {
        public int majorityElement(int[] nums) {
                int count = 0;
                int candidate = 0;
                        
                for (int num : nums) {
                        if (count == 0) {
                        candidate = num;
                        }
                        
                        if (num == candidate) {
                        count++;
                        } else {
                        count--;
                        }
                }
                
                return candidate;
        }

        public static void main(String[] args) {
                MajorityElementSolution s = new MajorityElementSolution();
                int[] nums1 = {3, 2, 3};
                int[] nums2 = {2, 1, 1, 1, 1, 2, 2};
                System.out.println(s.majorityElement(nums1)); //3
                System.out.println(s.majorityElement(nums2)); //2
        }
}
