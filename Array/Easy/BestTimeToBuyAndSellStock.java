package Array.Easy;

public class BestTimeToBuyAndSellStock {
    
    public int maxProfit(int[] prices) {
        int currentProfit = 0;
        int currentStock = prices[0];
    
        for(int i = 1; i < prices.length; i++) {
            if (currentStock > prices[i]) {
                currentStock = prices[i];
            } else if (prices[i] - currentStock > currentProfit) {
                currentProfit = prices[i] - currentStock;
            }
        }

        return currentProfit;
    }

}
