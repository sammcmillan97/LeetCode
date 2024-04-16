class SolutionRemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int ePointer = 0;
        int aPointer = 0;
        while(ePointer < nums.length) {
            int occurences = 1;
            int currentNum = nums[ePointer];

            while(ePointer < nums.length - 1 && nums[ePointer] == nums[ePointer + 1]) {
                occurences++;
                ePointer++;
            }
            ePointer++;

            if (occurences == 1) {
                nums[aPointer] = currentNum;
                aPointer++;
            } else {
                nums[aPointer] = currentNum;
                nums[aPointer + 1] = currentNum;
                aPointer += 2;
            }
        }
        return aPointer;
    }

    public static void main(String[] args) {
        SolutionRemoveDuplicates s = new SolutionRemoveDuplicates();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] nums2 = {0, 0, 1, 1, 1,1, 2, 3, 3};
        System.out.println(s.removeDuplicates(nums)); //5 
        System.out.println(s.removeDuplicates(nums2)); //7
    }
}