import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        Set<Integer> visited = new HashSet<Integer>();
        int numberOfDFSCalls = 0;
        Stack<Integer> frontier = new Stack<Integer>();

        for(int i = 0; i < isConnected.length; i++) {
            
            //Check that the node hasnt been visited before starting DFS
            if (!visited.contains(i)) {

                visited.add(i);
                numberOfDFSCalls++;

            //Start DFS at i and keep track of visited nodes 
            //Each DFS call is a new province
                for(int j=0; j < isConnected.length; j++) {

                    //Add all reachable nodes from i
                    if (isConnected[i][j] == 1) {
                        frontier.add(j);
                    }
                }

                //Run DFS
                while(frontier.size() > 0) {
                    int currentNode = frontier.pop();
                    if(!visited.contains(currentNode)) {

                        for(int k = 0; k < isConnected.length; k++) {
                            if (isConnected[currentNode][k] == 1) {
                                frontier.add(k);
                            }
                        }
                        visited.add(currentNode);
                    }
                
                }
            }

        }
        return numberOfDFSCalls;
    }

    public static void main(String[] args) {
        NumberOfProvinces s = new NumberOfProvinces();
        int[][] matrix = {
            {1, 0, 0, 1},
            {0, 1, 1, 0},
            {0, 1, 1, 1},
            {1, 0, 1, 1}
        };
        System.out.println(s.findCircleNum(matrix));
    }

}
