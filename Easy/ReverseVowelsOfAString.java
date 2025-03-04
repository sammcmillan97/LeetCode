package Easy;

import java.util.HashSet;
import java.util.Set;

class ReverseVowelsOfAString{

    public String reverseVowels(String s) {
        char charArray[] = s.toCharArray();

        int i = 0;
        int j = charArray.length - 1;
        Set<Character> setOfVowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        while(i < j) {

            while(!setOfVowels.contains(charArray[i]) & i < j) {
                i++;
            }
            while(!setOfVowels.contains(charArray[j]) & i < j) {
                j--;
            }
            char temp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = temp;
            i++;
            j--;
        }
        String returnString  = new String(charArray);
        return returnString;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        ReverseVowelsOfAString solution = new ReverseVowelsOfAString();

        System.out.println(solution.reverseVowels(s));
    }
}