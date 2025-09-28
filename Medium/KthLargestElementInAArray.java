
public class KthLargestElementInAArray {

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(0, nums.length - 1, nums.length - k, nums);
    }

    public int quickSelect(int l, int r, int k, int[] nums) {
        if (1 == selectPivot(l, r, nums)) {
            return nums[r];
        }
        
        int pivot = nums[r];
        int p = l;
        
        for(int i = l; i < r; i++) {

            if (nums[i] <= pivot) {
                swapIndex(p++, i, nums);
            } 
        }
        
        swapIndex(r, p, nums);

        if (k < p) {
            return quickSelect(l, p - 1, k, nums);
        } else if (k > p) {
            return quickSelect(p + 1, r, k, nums);
        } else {
            return nums[p];
        }

    }

    public void swapIndex(int x, int y, int[] list) {
        int temp = list[x];
        list[x] = list[y];
        list[y] = temp;
    }

    public int selectPivot(int l, int r, int[] nums) {
        int upper = r;
        int lower = l;
        int startingNumber = nums[l];
        if (nums[l] == nums[r]) {

            while(l < r) {
                if (nums[l] == startingNumber && startingNumber == nums[r]) {

                }  else {
                    if (nums[r] > startingNumber) {
                        //put larger number at end to create a better partition 
                        swapIndex(upper, r, nums);
                        return 0;
                    } else if (nums[l] > startingNumber) {
                        swapIndex(lower, l, nums);
                        return 0;
                    } else {
                        //Just ignore smaller number and contiune as normal
                        return 0;
                    }
                }
                r--;
                l++; 

            }
            //The whole section of nums is the same number so p must be that number
            return 1;

        } else {
            return 0;
        }
    }


    public static void main(String[] args) {
        KthLargestElementInAArray s = new KthLargestElementInAArray();
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(s.findKthLargest(nums, 4));
    }

    

}
