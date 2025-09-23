import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class EvaluateDivision {
    
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //Make the graph

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            
            graph.computeIfAbsent(equations.get(i).get(0), k -> new HashMap<>()).put(equations.get(i).get(1), values[i]);
            graph.computeIfAbsent(equations.get(i).get(1), k -> new HashMap<>()).put(equations.get(i).get(0), 1 / values[i]);
        }


        double[] results = new double[queries.size()];
        int i = 0;
        for (List<String> query : queries) {
            results[i] = bfs(query.get(0), query.get(1), graph);
            i++;
        }

        return results;
    }

    public double bfs(String source, String destination, Map<String, Map<String, Double>> graph) {
        
        if (!graph.containsKey(source) || !graph.containsKey(destination)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Queue<Double> values = new LinkedList<>();


        queue.add(source);
        values.add(1.0);
        Set<String> visited = new HashSet<String>();

        while(!queue.isEmpty()) {
            String current = queue.poll();
            Double currentValue = values.poll();

            if (!visited.contains(current)) {

                //Add all neighbours to queue
                for (Map.Entry<String, Double> entry : graph.get(current).entrySet()) {

                    if (entry.getKey().equals(destination)) {
                        return currentValue * entry.getValue();
                    }
                    Double newValue = currentValue * entry.getValue();
                    
                    queue.add(entry.getKey());
                    values.add(newValue);
                }
                visited.add(current);

            }
        }
        
        return -1;
    }


    public static void main(String[] args) {
        EvaluateDivision s = new EvaluateDivision();

        //  // Input: equations = [["a","b"],["b","c"]]
        // List<List<String>> equations = new ArrayList<>();
        // equations.add(Arrays.asList("a", "b"));
        // equations.add(Arrays.asList("b", "c"));

        // // values = [2.0, 3.0]
        // double[] values = {2.0, 3.0};

        // // queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
        // List<List<String>> queries = new ArrayList<>();
        // queries.add(Arrays.asList("a", "c"));
        // queries.add(Arrays.asList("b", "a"));
        // queries.add(Arrays.asList("a", "e"));
        // queries.add(Arrays.asList("a", "a"));
        // queries.add(Arrays.asList("x", "x"));

        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("c", "d")
        );

        double[] values = {1.0, 1.0};

        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "d"),
            Arrays.asList("b", "a"),
            Arrays.asList("d", "c")
        );

        // Call your function
        double[] result = s.calcEquation(equations, values, queries);

        // Print results
        System.out.println(Arrays.toString(result));
    }
}
