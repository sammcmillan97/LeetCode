public class ContainerWithMostWater {
    
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int bestVolume = 0;

        while (i < j) {
            int currentHeight = height[i] > height[j] ? height[j] : height[i];
            int currentVolume = currentHeight * Math.abs(i - j);
            if(bestVolume < currentVolume) {
                bestVolume = currentVolume;
            }

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return bestVolume;
    }
    
    public static void main(String[] args) {
        ContainerWithMostWater solution = new ContainerWithMostWater();
        int height[] = {1,8,6,2,5,4,8,25,7};
        System.out.println(solution.maxArea(height));
    }
}
