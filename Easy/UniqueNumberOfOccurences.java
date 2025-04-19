package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurences {
    public boolean uniqueOccurrences(int[] arr) {

        Map<Integer, Integer> values = new HashMap<>();
        
        for (int num : arr) {
            values.put(num, values.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> occurences = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : values.entrySet()) {
            if ( occurences.contains(entry.getValue())) {
                return false;
            } else {
                occurences.add(entry.getValue());
            }
        } 
        return true; 
    }
}
