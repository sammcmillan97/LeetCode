package dp.Easy;

public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        }
        int[] waysToClimb = new int[n];
        waysToClimb[0] = 1;
        waysToClimb[1] = 2;

        for(int i =2; i < n; i++) {
            waysToClimb[i] = waysToClimb[i - 2] + waysToClimb[i - 1];
        }
        
        return waysToClimb[n - 1];
    }

}
