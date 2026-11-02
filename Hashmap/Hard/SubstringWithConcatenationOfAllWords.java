package Hashmap.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {

        int wordLength = words[0].length();
        int windowLength = words.length * wordLength;
        int numberOfMatchedWords = 0;

        List<Integer> startingPoints = new ArrayList<>();

        Map<String, Integer> wordsMap = new HashMap<>();    //Word number of times in comes up in words
        Map<String, Integer> windowMap = new HashMap<>();

        for(String str : words) {
            wordsMap.merge(str, 1, Integer::sum);
        }

        int count = 0;

        while(count < wordLength) {
            windowMap.clear();
            int l = count;
            int r = 0;
            numberOfMatchedWords = 0;
            //Load initial window;
            for(int i = l; i < windowLength + l && i + wordLength < s.length() + 1; i+= wordLength) {
                String sub = s.substring(i, i + wordLength);
                if (wordsMap.containsKey(sub) && windowMap.containsKey(sub) && windowMap.get(sub) == wordsMap.get(sub)) {
                    numberOfMatchedWords--;
                }
                windowMap.merge(sub, 1, Integer::sum);
                if (windowMap.get(sub).equals(wordsMap.get(sub))) {
                    numberOfMatchedWords++;
                }
                r = i;
            }

            r+= wordLength;

            if (numberOfMatchedWords == wordsMap.size()) {
                startingPoints.add(count);
            }
            
            //do Sliding window
            while(r + wordLength < s.length() + 1) {

                String lSub = s.substring(l, l + wordLength);
                String rSub = s.substring(r, r + wordLength);

                //if they currently match they now wont
                if (wordsMap.containsKey(rSub) && windowMap.containsKey(rSub) && windowMap.get(rSub).equals(wordsMap.get(rSub))) {
                    numberOfMatchedWords--;
                }
                windowMap.merge(rSub, 1, Integer::sum);
                if (windowMap.get(rSub).equals(wordsMap.get(rSub))) {
                    numberOfMatchedWords++;
                }

                //if they currently match they now wont
                if (windowMap.get(lSub).equals(wordsMap.get(lSub))) {
                    numberOfMatchedWords--;
                }
                windowMap.put(lSub, windowMap.get(lSub) - 1);
                if (wordsMap.containsKey(lSub) && windowMap.containsKey(lSub) && windowMap.get(lSub).equals(wordsMap.get(lSub))) {
                    numberOfMatchedWords++;
                }
                
                l+= wordLength;
                r+= wordLength;

                if (numberOfMatchedWords == wordsMap.size()) {
                    startingPoints.add(l);
                }
            }
            count++;
        }
        return startingPoints;
    }
    
    public static void main(String[] args) {
        SubstringWithConcatenationOfAllWords s = new SubstringWithConcatenationOfAllWords();
        String str = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        List<Integer> answer = s.findSubstring(str, words);
        for (int inte : answer) {
            System.out.println(inte);
        }
    }


}
