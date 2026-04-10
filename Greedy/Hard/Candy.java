package Greedy.Hard;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] numberOfCandy = new int[n];  
        
        for(int i = 0; i < n; i++) {
            numberOfCandy[i] = 1;
        }
        
        //left pass
        for(int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                numberOfCandy[i] = numberOfCandy[i - 1] + 1;
            }
        }

        //right pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                numberOfCandy[i] = Math.max(numberOfCandy[i], numberOfCandy[i + 1] + 1);
            }
        }
        
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum+= numberOfCandy[i];
        }

        return sum;
    }
}
