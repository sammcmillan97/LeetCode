import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    
    public int minReorder(int n, int[][] connections) {
        
        Map<Integer, List<int[]>> paths = new HashMap<>();
        int reversals = 0;
        //Path example (1, 2, 0) 2 -> 1, (1, 2, 1) 1 -> 2

        for(int i = 0; i < connections.length; i++) {
            
            int[] pathX = new int[]{connections[i][0], connections[i][1], 1};
            int[] pathY = new int[]{connections[i][1], connections[i][0], 0};

            if (paths.containsKey(connections[i][0])) {
                paths.get(connections[i][0]).add(pathX);
            } else{
                List<int[]> listOfPathsForCity = new ArrayList<>();
                listOfPathsForCity.add(pathX);
                paths.put(connections[i][0], listOfPathsForCity);
            }

            if (paths.containsKey(connections[i][1])) {
                paths.get(connections[i][1]).add(pathY);
            } else{
                List<int[]> listOfPathsForCity = new ArrayList<>();
                listOfPathsForCity.add(pathY);
                paths.put(connections[i][1], listOfPathsForCity);
            }
        }
        
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);


        while(stack.size() != 0) {
            int currentCity = stack.pop();
            List<int[]> neighbours = paths.get(currentCity);

            for(int[] neighbour : neighbours) {

                if(!visited.contains(neighbour[1])) {

                    //If outward add 1 to rerversal
                    if (neighbour[2] == 1) {
                        reversals++;
                    }
                    //add to neighbour to stack
                    stack.add(neighbour[1]);


                }
            }
            visited.add(currentCity);
        }
        return reversals;

    }

    public void printPaths(Map<Integer, List<int[]>> paths) {        
        for(Entry<Integer, List<int[]>> entry : paths.entrySet()) {
            
            System.out.println("Key: " + entry.getKey());

            for(int[] x : entry.getValue()) {
                if (x[2] == 1) {
                    System.out.println(x[0] + " -> " + x[1]);
                } else {
                    System.out.println(x[1] + " -> " + x[0]);
                }

            }
        }
    }

    public static void main(String[] args) {
        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };

        ReorderRoutesToMakeAllPathsLeadToTheCityZero s = new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
        System.out.println(s.minReorder(6, connections));
    }

}
