import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);  // primary sort
                }
                return Integer.compare(a[1], b[1]);      // secondary sort
            }
        );

        int l = -1;
        int r = costs.length;
  
        while(l < r & l < candidates - 1) {
            l++;
            if (l != r) {
                int[] leftNew = {costs[l] , l};
                pq.offer(leftNew);
            }
            
            r--;
            if (l < r) {
                int[] rightNew = {costs[r] , r};
                pq.offer(rightNew);
            }
        }

        while(0 < k) {
            int[] newHire = pq.poll();
            int costOfNewHire = newHire[0];
            int indexOfNewHire = newHire[1];

            totalCost += costOfNewHire;

            if (l < r) {
                if(indexOfNewHire <= l) {
                    l++;
                    if (l != r) {
                        int[] newCandidate = {costs[l], l};
                        pq.offer(newCandidate);
                    }
                } else {
                    r--;
                    if (l != r) {
                        int[] newCandidate = {costs[r], r};
                        pq.offer(newCandidate);
                    }
                }
            }
            k--;
        }

        return totalCost;
    }


    public static void main(String[] args) {
        int[] costs = {60,66,17,17,35,46,77,7,15,38,35,61,90,34,29,68,35,9,18,82,78,40,8 ,71,2,59,70,12,88,73,12,55,88,59,71,49,47,46,65,37,24,75,81,54,39,70};
        System.out.println(costs.length);
        int k = 37;
        int candidates = 40;

        TotalCostToHireKWorkers s = new TotalCostToHireKWorkers();
        System.out.println(s.totalCost(costs, k, candidates));
    }
}
