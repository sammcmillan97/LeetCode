import java.util.HashMap;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        
        Map<Character, Integer> lettersInWord1 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            lettersInWord1.put(word1.charAt(i), lettersInWord1.getOrDefault(word1.charAt(i) ,0) + 1);
        }

        Map<Integer, Integer> letterAmmounts = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : lettersInWord1.entrySet()) {
            letterAmmounts.put(entry.getValue(), letterAmmounts.getOrDefault(entry.getValue(), 0) + 1);
        }

        Map<Character, Integer> lettersInWord2 = new HashMap<>();

        for (int i = 0; i < word2.length(); i++) {
            lettersInWord2.put(word2.charAt(i), lettersInWord2.getOrDefault(word2.charAt(i) ,0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : lettersInWord2.entrySet()) {
            

            if(letterAmmounts.containsKey(entry.getValue()) && letterAmmounts.get(entry.getValue()) > 0 && lettersInWord1.containsKey(entry.getKey())) {
                letterAmmounts.put(entry.getValue(), letterAmmounts.get(entry.getValue()) - 1);
            } else {
                return false;
            }
        }

        for (Integer numberLeft : letterAmmounts.values()) {
            if (numberLeft != 0) {
                return false;
            }
        }
        return true; 
    }

    public static void main(String[] args) {
        String word1 = "uau";
        String word2 = "ssx";
        DetermineIfTwoStringsAreClose s  = new DetermineIfTwoStringsAreClose();
        System.out.println(s.closeStrings(word1, word2) );
    }

}
