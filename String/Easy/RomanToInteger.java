import java.util.Map;
import java.util.HashMap;

public class RomanToInteger {

    Map<Character, Integer> romanConversation = new HashMap<>(Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100, 'D', 500, 'M', 1000));

    public int romanToInt(String s) {
        int sum = 0;
        for(int i = 0; i < s.length(); i++) {
            int num = romanConversation.get(s.charAt(i));
            if (i != s.length() - 1 && num < romanConversation.get(s.charAt(i + 1))) {
                sum+= num;
            } else {
                sum-= num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String romanNumeral = "CMXLIV";
        RomanToInteger solution = new RomanToInteger();
        System.out.println(solution.romanToInt(romanNumeral));
    }

}
