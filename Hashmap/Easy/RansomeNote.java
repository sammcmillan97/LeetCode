package Hashmap.Easy;

import java.util.HashMap;
import java.util.Map;

public class RansomeNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineSet = new HashMap<>();

        for(char c : magazine.toCharArray()) {
            magazineSet.put(c, magazineSet.getOrDefault(c, 0) + 1);
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (!magazineSet.containsKey(c) || magazineSet.get(c) == 0) {
                return false;
            }
            magazineSet.put(c, magazineSet.get(c) - 1);
        }

        return true;
    }

}
