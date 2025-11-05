package Easy;

import java.util.HashMap;
import java.util.Map;

public class MinCostClimbingStairs {

    //Top Down 
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> cache = new HashMap<>();
        return Math.min(minCostClimbingStairsRecurse(cost, 0, 0, cache), minCostClimbingStairsRecurse(cost, 1, 0, cache));
    }

    public int minCostClimbingStairsRecurse(int[] cost, int i, int current, Map<Integer, Integer> cache) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        if (i >= cost.length) {
            return current;
        }

        int minAtIndex = Math.min(minCostClimbingStairsRecurse(cost, i + 1, current + cost[i], cache), minCostClimbingStairsRecurse(cost, i + 2, current + cost[i], cache));
        cache.put(i, minAtIndex);
        return minAtIndex;
    }

//Bottom up
    // public int minCostClimbingStairs(int[] cost) {

    //     int i = cost.length - 3;

    //     while(i >= 0) {

    //         int x = cost[i] + cost[i + 1];
    //         int y = cost[i] + cost[i + 2];

    //         if (x < y ) {
    //             cost[i] = x;
    //         } else {
    //             cost[i] = y;
    //         }
    //         i--;
    //     }
    //     return Math.min(cost[0], cost[1]);
    // }

    public static void main(String[] args) {
        MinCostClimbingStairs s = new MinCostClimbingStairs();
        int[] cost = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(s.minCostClimbingStairs(cost));
    }

}
