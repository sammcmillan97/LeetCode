package dp.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {
    
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> startingPoints = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++) {
            boolean foundAtThisIndex = false; 
            for (int j = 0; j < words.length; j++) {
                
                if(!foundAtThisIndex && s.startsWith(words[j], i)) {
                    Set<Integer> used = new HashSet<>();
                    used.add(j);
                    int start = i + words[j].length();
                    boolean keepGoing = true;
                    while(keepGoing) {
                        int currentStart = start;
                        if (used.size() == words.length) {
                            startingPoints.add(i);
                            keepGoing = false;
                            foundAtThisIndex = true;
                        } else {
                            for (int k = 0; k < words.length; k++) {
                                if (!used.contains(k)) {
                                    if(s.startsWith(words[k], start)) {
                                        used.add(k);
                                        start += words[k].length();
                                    }
                                }
                            }
                        }
                        if (currentStart == start) {
                             keepGoing = false;
                        }
                    }
                }

            }
        }
        return startingPoints;
    }

    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        String[] words  = {"foo","bar"};
        String str = "barfoothefoobarman";

        System.out.println(s.findSubstring(str, words));
    }


}
