package Easy;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class GreatestCommonDivisorOfStrings {

    // public String gcdOfStrings(String str1, String str2) {
    //     Set<String> setOfDivsorsOne = GetCollectionOfDivisors(str1);
    // Set<String> setOfDivsorsTwo = GetCollectionOfDivisors(str2);

    // setOfDivsorsOne.retainAll(setOfDivsorsTwo);

    // String largestCommonDivisor = "";

    // for (String common : setOfDivsorsOne) {
    //     if (common.length() > largestCommonDivisor.length()) {
    //         largestCommonDivisor = common;
    //     }
    // }

    // return largestCommonDivisor;
    // }

    // public Set<String> GetCollectionOfDivisors(String str) {

    // int stringLength = str.length();
    // List<String> contenderStrings = new ArrayList();
    // Set<String> setOfDivisors = new HashSet<>();

    // for(int i = 1; i <= Math.sqrt(stringLength); i++) {
    //     if(stringLength % i == 0) {
    //         contenderStrings.add(str.substring(0, stringLength / i));
    //         contenderStrings.add(str.substring(0, i));
    //     }
    // }

    // for (String contender : contenderStrings) {
    //     boolean match = true; 
    //     for (int i = contender.length(); i <= stringLength - contender.length(); i += contender.length()) {
    //         String compairson = str.substring(i, i + contender.length());
    //         if (!contender.equals(compairson)) {
    //             match = false;
    //             break;
    //         }
    //     }
    //     if (match) {
    //         setOfDivisors.add(contender);
    //     }
    // }
    //     return setOfDivisors;
    // }

    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        return str1.substring(0, euclid(str1.length(), str2.length()));
    }

    public int euclid(int x, int y) {
        if(y == 0) {
            return x;
        }
        return euclid(y, x % y);
    }

    public static void main(String[] args) {
        GreatestCommonDivisorOfStrings solution = new GreatestCommonDivisorOfStrings();
        String str1 = "ABABAB";
        String str2 = "ABAB";
        System.out.println(solution.gcdOfStrings(str1, str2));
    }

}
