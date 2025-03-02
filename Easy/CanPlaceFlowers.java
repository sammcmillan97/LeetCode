package Easy;

public class CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        int freeSpots = 0;

        if(flowerbed.length == 1) {
            return (flowerbed[0] == 0 && n == 1 || n == 0);
        }

        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            flowerbed[0] = 1;
            freeSpots += 1;
        }

        if(flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length -2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            freeSpots += 1;
        }

        for (int i = 1; i < flowerbed.length - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                freeSpots += 1;
            }
        }

        return freeSpots >= n;
    }
    }

    public static void main(String[] args) {
        CanPlaceFlowers solution = new CanPlaceFlowers();
        int[] flowerbed = {1, 0, 0, 0, 1};
        System.out.println(solution.canPlaceFlowers(flowerbed, 2));
    }
    
}
