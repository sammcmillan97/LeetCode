//139. Word Break
package dp.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> cache = new HashSet<>();
        return wordBreakRecurse(s, wordDict, cache); 
    }

    public boolean wordBreakRecurse(String s, List<String> wordDict, Set<String> cache) {
        if (s == "") {
            return true;
        }

        for(String word : wordDict) {
            if(isSubStringMatch(s, word)) {
                String key = s + "," + word;
                if (!cache.contains(key)) {
                    boolean result = wordBreak(s.substring(word.length(), s.length()), wordDict);
                    if(result) {
                        return true;
                    } else {
                        cache.add(key);
                    }
                }
            }
        }
        return false;
    }

    public boolean isSubStringMatch(String mainString, String comparisonString) {
        int i = 0;
        int j = 0;

        while(i < mainString.length() && j < comparisonString.length()) {
            if (mainString.charAt(i) != comparisonString.charAt(j)) {
                return false;
            }
            i++;
            j++;
        }

        if (j >= comparisonString.length()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        String one = "leetcode";
        List<String> wordDict = List.of("leet","code");

        WordBreak s = new WordBreak();
        System.out.println(s.wordBreak(one, wordDict));
    }


}
