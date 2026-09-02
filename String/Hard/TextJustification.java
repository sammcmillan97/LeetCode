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
            StringBuilder sb = new StringBuilder();
            if (i != words.length ) {
                lineSize-= line.size();
                
                int numberOfSpaces = line.size() - 1; //number of words - 1
                numberOfSpaces = numberOfSpaces == 0 ? numberOfSpaces + 1 : numberOfSpaces;

                int whiteSpace = maxWidth - lineSize;
                int widthPerSpace = whiteSpace / numberOfSpaces;
                int numberOfLargerSpaces = whiteSpace - (widthPerSpace * numberOfSpaces); // spaces with the size = 1 + widthPerSpace

                for (int j = 0; j < line.size(); j++) {
                    sb.append(line.get(j));
                    if (whiteSpace != 0) {
                        int widthOfCurrentSpace = widthPerSpace;
                        if (numberOfLargerSpaces > 0) {
                            widthOfCurrentSpace++;
                            numberOfLargerSpaces--;
                        }
                        sb.append(" ".repeat(widthOfCurrentSpace));
                        whiteSpace-= widthOfCurrentSpace;
                    }
                }
            } else {
                int lastLineSize = 0;
                for (int j = 0; j < line.size(); j++) {
                    sb.append(line.get(j));
                    lastLineSize+= line.get(j).length();
                    if (lastLineSize != maxWidth) {
                        sb.append(" ");
                        lastLineSize++;
                    }
                }
                sb.append(" ".repeat(maxWidth - lastLineSize));
            }

            lines.add(sb.toString());
        }
        return lines;
    }


    public static void main(String[] args) {
        TextJustification s = new TextJustification();
        String[] words = {"What","must","be","acknowledgment","shall","be"};
        System.out.println(s.fullJustify(words, 16));
    }
}
