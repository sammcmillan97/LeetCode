import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> charIndexes = new HashMap<>();
        int startingIndex =  -1;
        int lengthOfLongest = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charIndexes.containsKey(c)) {
                if (charIndexes.get(c) > startingIndex) {
                    startingIndex = charIndexes.get(c);
                } 
            }

            int lengthOfCurrent = i - startingIndex;
            if (lengthOfCurrent > lengthOfLongest) {
                lengthOfLongest = lengthOfCurrent;
            } 
            charIndexes.put(c, i);
        }
        
        return lengthOfLongest;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        String str = "pwpabc";
        System.out.println(s.lengthOfLongestSubstring(str));
    }

}
