package Easy;

class MergeSortedArraySolution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int j = m - 1; 
        int k = n - 1;

        while(i > -1) {
            if (k == -1 || (j != -1 && nums1[j] > nums2[k])) {
                nums1[i] = nums1[j];
                i--;
                j--;
            } else {
                nums1[i] = nums2[k];
                i--;
                k--;
            }   
        }
    } 

    public static void main(String[] args) {
        MergeSortedArraySolution s = new MergeSortedArraySolution();
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
        s.merge(nums1, 3, nums2 , 3);
        for(int num : nums1) {
            System.out.println(num);
        }
    }
}