public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while(l < r) {
            int i = ((r - l) / 2) + l;

             
            if (nums[i] > nums[i + 1]) {
                r = i;
            } else  {
                l = i + 1;
            }
        }

        return r;
    }

    public static void main(String[] args) {
        // FindPeakElement s = new FindPeakElement();
        // int[] nums = {1, 2, 3, 4, 5};
        // System.out.println(s.findPeakElement(nums));
        System.out.println(5 / 2);
        System.out.println(4 / 2);
    }
}
