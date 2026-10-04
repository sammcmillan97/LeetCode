package dp.Medium;

import java.util.Arrays;


public class CoinChange {
    // public int coinChange(int[] coins, int amount) {
    //     int[] memo = new int[amount + 1];
    //     Arrays.fill(memo, -1);

    //     int returnValue = coinChangeRecurse(coins, amount, memo);
    //     if (returnValue == Integer.MAX_VALUE) {
    //         return -1;
    //     } else {
    //         return returnValue;
    //     }


    // }

    // private int coinChangeRecurse(int[] coins, int amount, int[] memo) {
    //     if (amount == 0) {
    //         return 0;
    //     }

    //     if (amount < 0) {
    //         return Integer.MAX_VALUE;
    //     }

    //     if (memo[amount] != -1) {
    //         return memo[amount];
    //     }

    //     int min = Integer.MAX_VALUE;

    //     for (int coin : coins) {
    //         int result = coinChangeRecurse(coins, amount - coin, memo);

    //         if (result != Integer.MAX_VALUE) {
    //             min = Math.min(min, result + 1);
    //         }
    //     }

    //     memo[amount] = min;
    //     return min;
    // }

    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = -1;
        }

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < dp.length) {
                dp[coins[i]] = 1;
            }
        }

        for (int i = 1; i < dp.length; i++) {

            int minValue = Integer.MAX_VALUE;
            
            for (int j = 0; j < coins.length; j++) {

                int potenialMin = Integer.MAX_VALUE;
                int index = i - coins[j];

                if (index >= 0 && dp[index] != -1) {

                    potenialMin = 1 + dp[index];

                    if (potenialMin < minValue) {
                        minValue = potenialMin;
                    }
                }
            }

            dp[i] = minValue == Integer.MAX_VALUE ? -1 : minValue;
        }
        return dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int output = 8;

        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, output));
    }
}
