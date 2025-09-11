import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    
    public int minReorder(int n, int[][] connections) {
        
        Map<Integer, List<int[]>> paths = new HashMap<>();

        //Path example (1, 2, 0) 2 -> 1, (1, 2, 1) 1 -> 2

        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < connections.length; i++) {
            
            int[] pathX = new int[]{connections[i][0], connections[i][1], 1};
            int[] pathY = new int[]{connections[i][1], connections[i][0], 0};

            
        }

        return -1;

    }

}
