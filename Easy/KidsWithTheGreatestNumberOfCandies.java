package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
            int mostCandies = candies[0];
            List<Boolean> theMostList = new ArrayList<>();
            for (int i = 1; i < candies.length; i++) {
                if (candies[i] > mostCandies) {
                    mostCandies = candies[i];
                }
            }

            for (int candy : candies) {
                theMostList.add(candy + extraCandies  >= mostCandies);
            }
            return theMostList;
    }

    public static void main(String[] args) {
        KidsWithTheGreatestNumberOfCandies solution = new KidsWithTheGreatestNumberOfCandies();
        int[] candies = {2, 3, 5, 1, 3};
        System.out.println(solution.kidsWithCandies(candies, 3));
    }
}
