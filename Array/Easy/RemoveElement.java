//27. Remove Element
package Array.Easy;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int l = 0;
        int r = nums.length - 1;

        while(l <= r) {
            if (nums[r] == val) {
                r--;
            } else if (nums[l] == val) {
                nums[l] = nums[r];
                nums[r] = val;
                l++;
                r--;
            } else {
                l++;
            }

        }

        return l;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int val = 2;
        RemoveElement s = new RemoveElement();
        System.out.println(s.removeElement(nums, val));
    }
}
