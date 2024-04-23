public class BestTimeToBuyTwoSolution {
    public int maxProfit(int[] prices) {
        int sumTotal = 0;
        for(int i = 0; i < prices.length - 1; i++) {
            int difference =  prices[i + 1] - prices[i];
            if (difference > 0) {
                sumTotal+= difference;
            }
        }
        return sumTotal;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyTwoSolution s = new BestTimeToBuyTwoSolution();
        System.out.println(s.maxProfit(nums));
    }
}