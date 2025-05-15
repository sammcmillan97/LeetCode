import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

    public int equalPairs(int[][] grid) {
        
        Map<String, Integer> rows = new HashMap<>();
        int numberOfMatches = 0;

        for (int i = 0; i < grid.length; i++ ) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                s.append(grid[i][j]);
                s.append(",");
            }
            String key = s.toString();
            rows.put(key, rows.getOrDefault(key, 0) + 1);
        }
        
        for (int i = 0; i < grid.length; i++ ) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                s.append(grid[j][i]);
                s.append(",");
            }
            String key = s.toString();
            if (rows.containsKey(key)) {
                numberOfMatches+= rows.get(key);
            }
        }
        return numberOfMatches;
    }

    public static void main(String[] args) {
        EqualRowAndColumnPairs s = new EqualRowAndColumnPairs();
        int[][] grid = {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}};
        System.out.println(s.equalPairs(grid));
    }

}
