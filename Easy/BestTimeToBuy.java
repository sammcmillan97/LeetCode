package Easy;

public class BestTimeToBuy {
    public int maxProfit(int[] prices) {
        int biggestGap = 0;
        int currentSmallest = prices[0];
        for(int i = 0; i < prices.length; i++) {
            if (prices[i] < currentSmallest) {
                currentSmallest = prices[i];
            } else {
                if ((prices[i] - currentSmallest) > biggestGap) {
                    biggestGap = prices[i] - currentSmallest;
                }
            }
        }
        return biggestGap;
    }

    public static void main(String[] args) {
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        BestTimeToBuy s = new BestTimeToBuy();
        System.out.println(s.maxProfit(nums));
    }
}
