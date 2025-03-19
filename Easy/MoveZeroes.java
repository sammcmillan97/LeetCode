package Easy;

class MoveZeroes {
    public void moveZeroes(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while(j != 0 && nums[j - 1] == 0) {
                int temp = nums[j - 1];
                nums[j - 1] = nums[j];
                nums[j--] = temp;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        int nums[] = {0,1,0,3,12};
        solution.moveZeroes(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }
}