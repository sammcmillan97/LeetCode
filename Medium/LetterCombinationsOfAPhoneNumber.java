import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {


    //Iteration
    // public List<String> letterCombinations(String digits) {
        
    //     Map<Character, Character[]> letters = new HashMap<>();
    //     letters.put('2', new Character[] {'a', 'b', 'c'});
    //     letters.put('3', new Character[] {'d', 'e', 'f'});
    //     letters.put('4', new Character[] {'g', 'h', 'i'});
    //     letters.put('5', new Character[] {'j', 'k', 'l'});
    //     letters.put('6', new Character[] {'m', 'n', 'o'});
    //     letters.put('7', new Character[] {'p', 'q', 'r', 's'});
    //     letters.put('8', new Character[] {'t', 'u', 'v'});
    //     letters.put('9', new Character[] {'w', 'x', 'y', 'z'});

    //     int i = 0;
    //     List<String> result  = new ArrayList<>();
    //     result.add("");

    //     while(i < digits.length()) {
    //         Character[] chars = letters.get(digits.charAt(i));
    //         List<String> temp = new ArrayList<>();
    //         for (String x : result) {
    //             for (Character c : chars) {
    //                 temp.add(x + c);
    //             }
    //         }
    //         result = temp
    //         i++;
    //     }

    //     result.removeIf(x -> x.length() < digits.length());

    //     return result; 

    // }


    //Recursion
    public List<String> letterCombinations(String digits) {

        Map<Character, Character[]> letters = new HashMap<>();
        letters.put('2', new Character[] {'a', 'b', 'c'});
        letters.put('3', new Character[] {'d', 'e', 'f'});
        letters.put('4', new Character[] {'g', 'h', 'i'});
        letters.put('5', new Character[] {'j', 'k', 'l'});
        letters.put('6', new Character[] {'m', 'n', 'o'});
        letters.put('7', new Character[] {'p', 'q', 'r', 's'});
        letters.put('8', new Character[] {'t', 'u', 'v'});
        letters.put('9', new Character[] {'w', 'x', 'y', 'z'});

        List<String> result = new ArrayList<>();
        letterRecurse(0, result, digits, letters, "");
        return result;
    }

    public void letterRecurse(int i, List<String> result, String digits, Map<Character, Character[]> letters, String str) {
        if (i == digits.length()) {
            result.add(str);
            return;
        }

        for (Character c : letters.get(digits.charAt(i))) {
            String temp = str + c;
            letterRecurse(i + 1, result, digits, letters, temp);
        }
    }


    public static void main(String[] args) {
        String digits = "23";
        LetterCombinationsOfAPhoneNumber s = new LetterCombinationsOfAPhoneNumber();
        System.out.println(s.letterCombinations(digits));
    }
}
