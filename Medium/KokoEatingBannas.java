public class KokoEatingBannas {

    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
         
        for (int pile : piles) {    
            if (maxPile < pile) {
                maxPile = pile;
            }
        }

        int result = maxPile;

        int l = 1;
        int r = maxPile;

        while (l <= r) {
            int speed = Math.floorDiv((l + r), 2);
            int hours = 0;
            for(int pile : piles) {
                hours += Math.ceilDiv(pile, speed);
            }

            if (hours <= h) {
                if (result > speed) {
                    result = speed;
                }
                r = speed - 1;
            } else {
                l = speed + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        KokoEatingBannas s = new KokoEatingBannas();
        int[] piles = {30,11,23,4,20};
        System.out.println(s.minEatingSpeed(piles, 5));
    }

}
