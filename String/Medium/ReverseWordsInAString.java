package String.Medium;

import java.util.Arrays;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        char[] words = s.toCharArray();
        //Reverse Entire String
        reverseString(words);

        int i = 0;
        int lengthOfWords = words.length;
        int write = 0;
        while(i < lengthOfWords) {
            //Find start of word, left pointer 
            while(i < lengthOfWords && words[i] == ' ') {
                i++;
            }

            // We reached the end
            if (i >= lengthOfWords) {
                break;
            }

            int r = i;
            //Find end of word, right pointer
            while(r < lengthOfWords && words[r] != ' ') {
                r++;
            }
            //Reverse Word in place
             reverseString(words, i, r - 1);

            //Add white space before new word
            if (write > 0) {
                words[write++] = ' ';
            }

            // Copy word (consuming whitespace)
            while (i < r) {
                words[write++] = words[i++];
            }

        }

        String result = String.valueOf( Arrays.copyOfRange(words, 0, write));
        return result;
    }


    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;

        reverseString(s, l, r);
    }

    public void reverseString(char[] s, int l, int r) {
        while(l < r) {
            char charBuffer = s[r];
            s[r] = s[l];
            s[l] = charBuffer;
            l++;
            r--;
        }
    }


    public static void main(String[] args) {
        ReverseWordsInAString s = new ReverseWordsInAString();
        String input = "hello world";
        System.out.println(s.reverseWords(input));
    }
}

