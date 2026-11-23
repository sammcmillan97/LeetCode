package Hashmap.Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> letterTranslations = new HashMap<>();
        Set<Character> inSet = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (letterTranslations.containsKey(s.charAt(i)) && letterTranslations.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            } else if (!letterTranslations.containsKey(s.charAt(i)) && inSet.contains(t.charAt(i))) {
                return false; 
            } else if (!letterTranslations.containsKey(s.charAt(i))) {
                letterTranslations.put(s.charAt(i), t.charAt(i));
                inSet.add(t.charAt(i));
            }  
        }
        return true;
    }



    public static void main(String[] args) {
        IsomorphicStrings sol = new IsomorphicStrings();
        String s  = "paper";
        String t = "title";
        System.out.println(sol.isIsomorphic(s, t));
    }
}
