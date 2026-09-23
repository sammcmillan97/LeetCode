//139. Word Break
package dp.Medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        return canBreak(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
    }

    private boolean canBreak(String s, int start, Set<String> dict, Boolean[] memo) {
        if (start == s.length()) return true;
        if (memo[start] != null) return memo[start];

        for (String word : dict) {
            if (s.startsWith(word, start) && canBreak(s, start + word.length(), dict, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    public static void main(String[] args) {

        String one = "leetcode";
        List<String> wordDict = List.of("leet","code");

        WordBreak s = new WordBreak();
        System.out.println(s.wordBreak(one, wordDict));
    }


}
