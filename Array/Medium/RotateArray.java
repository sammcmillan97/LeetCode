package Array.Medium;

public class RotateArray {

    public void rotate(int[] nums, int k) {
        int n = nums.length - 1;
        k = k % nums.length;
        reverseArray(nums, 0, n);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n);
    }

    public void reverseArray(int[] nums, int l, int r) {

        while(l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        RotateArray s = new RotateArray();
        s.rotate(nums, 1);
        System.out.println(nums);
    }

}
