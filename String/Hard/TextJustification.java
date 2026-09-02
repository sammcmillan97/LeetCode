package String.Hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;
        List<String> lines = new ArrayList<>();
        while(i < words.length) {
            List<String> line = new ArrayList<>();
            int lineSize = 0;
            boolean lineNotFull = true;

            while(lineNotFull && i < words.length) {
                String currentWord = words[i];
                if(lineSize + currentWord.length() <= maxWidth) {
                    line.add(currentWord);
                    lineSize+= currentWord.length();
                    //Add space
                    lineSize++;
                    i++;
                } else {
                    lineNotFull = false;
                }
                
            }

            //Now line size just represents the length in words by removing any added space
            lineSize-= line.size();
            
            int numberOfSpaces = line.size() - 1; //number of words - 1
            numberOfSpaces = numberOfSpaces == 0 ? numberOfSpaces + 1 : numberOfSpaces;

            int whiteSpace = maxWidth - lineSize;
            int widthPerSpace = whiteSpace / numberOfSpaces;
            int numberOfLargerSpaces = whiteSpace - (widthPerSpace * numberOfSpaces); // spaces with the size = 1 + widthPerSpace

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < line.size(); j++) {
                sb.append(line.get(j));
                if (j != line.size() - 1) {
                    int widthOfCurrentSpace = widthPerSpace;
                    if (numberOfLargerSpaces > 0) {
                        widthOfCurrentSpace++;
                        numberOfLargerSpaces--;
                    }
                    sb.append(" ".repeat(widthOfCurrentSpace));
                }
            }
            lines.add(sb.toString());
        }
        return lines;
    }


    public static void main(String[] args) {
        TextJustification s = new TextJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "1234567891123456"};
        System.out.println(s.fullJustify(words, 16));
    }
}
