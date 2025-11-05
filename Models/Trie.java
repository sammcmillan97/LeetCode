package Models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import Models.TriePath;

public class Trie {

    public Map<Character, Trie> children;
    public boolean isCompleteWord;

    public Trie() {
        children = new HashMap<Character, Trie>();
        isCompleteWord = false;
    }

    //Iterative
     
    public void insert(String word) {
        Trie current = this;
        for (char c : word.toCharArray()) {
            current.children.putIfAbsent(c, new Trie());
            current = current.children.get(c);
        }
        current.isCompleteWord = true;
    }
    
    public boolean search(String word) {
        Trie current = this;
        for(char c : word.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }
        return current.isCompleteWord;
    }
    
    public boolean startsWith(String prefix) {
        Trie current = this;
        for(char c : prefix.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }
        return true;
    }

    public List<String> returnMatchingWords(String prefix, int maxWords) {
        Trie current = this;
        List<String> result = new ArrayList<>();

        for(char c : prefix.toCharArray()) {
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                //No words match suggestion
                return result;
            }
        }


        PriorityQueue<TriePath> pq = new PriorityQueue<>(
            (a, b) -> a.word.compareToIgnoreCase(b.word)
        );

       pq.add(new TriePath(current, prefix));

        while(!pq.isEmpty() && result.size() < maxWords) {
            
            TriePath path = pq.poll();
            for (Map.Entry<Character, Trie> kv : path.trie.children.entrySet()) {
                TriePath newPath = new TriePath(kv.getValue(), path.word + kv.getKey());
                pq.add(newPath);
            }
            if (path.trie.isCompleteWord) {
                result.add(path.word);
            }
        }

        return result;
    }
    

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> results = new ArrayList<>();
        for(String product : products) {
            this.insert(product);
        }
        String word =  "";
        for (char c : searchWord.toCharArray()) {
            word+= c;
            List<String> suggetsions = this.returnMatchingWords(word, 3);
            results.add(suggetsions);
        }

        return results;
    }

    //Recursive
    // public void insert(String word) {
    //     if (word != "") {

    //         char current = word.charAt(0);
    //         if (children.containsKey(current)) {
    //             children.get(current).insert(word.substring(1, word.length()));

    //         } else {
    //             Trie child = new Trie();
    //             child.insert(word.substring(1, word.length()));  
    //             children.put(current, child);
    //         }   
    //     } else {
    //         this.isCompleteWord = true;
    //     }
    // }
    
    // public boolean search(String word) {
    //     if (word == "") {
    //         return this.isCompleteWord;
    //     }

    //     char currentCharacter = word.charAt(0);
    //     if (!children.containsKey(currentCharacter)) {
    //         return false;
    //     }
    //     return children.get(currentCharacter).search(word.substring(1, word.length()));
    // }
    
    // public boolean startsWith(String prefix) {
    //     if (prefix == "") {
    //         return true;
    //     }
    //     char currentCharacter = prefix.charAt(0);
    //     if (!children.containsKey(currentCharacter)) {
    //         return false;
    //     }
    //     return children.get(currentCharacter).startsWith(prefix.substring(1, prefix.length()));
    // }


    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] products = new String[] {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> result = trie.suggestedProducts(products, searchWord);
        for (List<String> words : result) {
            System.out.println("\n");
            for(String word : words) {
                System.out.println(word);
            }
        }
    }

    

}

