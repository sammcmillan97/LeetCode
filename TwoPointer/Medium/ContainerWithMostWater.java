package TwoPointer.Medium;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int largestContainerWithMostWater = 0;
        while(l < r) {
            int currentContainer = Math.min(height[l], height[r]) * (r - l);

            if(largestContainerWithMostWater < currentContainer) {
                largestContainerWithMostWater = currentContainer;
            }

            if(height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return largestContainerWithMostWater;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater s = new ContainerWithMostWater();
        System.out.println(s.maxArea(height));
    }

}
