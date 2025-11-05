public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int buyPrice = prices[0];    
        for(int i = 1; i < prices.length; i++) {
            profit = Math.max(profit, (prices[i] - buyPrice - fee));
            buyPrice = Math.min(buyPrice, prices[i] - profit);
        }
        return profit;
    }

}
