public class ReverseWordsInAString {

    public String reverseWords(String s) {
        char[] charArray = (s.trim()).toCharArray();
        char[] returnArray = new char[charArray.length];

        int i = charArray.length -1;
        int wordLength = 0;
        int returArrayIndex = 0;
        while(i > 0) {
            
            while(i >= 0 && !Character.isWhitespace(charArray[i])) {
                i--;
                wordLength++;
            }

            for(int j = 1; j <= wordLength; j++) {
                returnArray[returArrayIndex] = charArray[i + j];
                returArrayIndex++;
            }

            if(i < 0) {
                break;
            }

            returnArray[returArrayIndex] = ' ';
            returArrayIndex++;

            while(Character.isWhitespace(charArray[i])) {
                i--;
            }

            wordLength = 0;
        }
        return new String(returnArray).trim(); 
    }

    public static void main(String[] args){
        String s = "a good   example";
        ReverseWordsInAString solution = new ReverseWordsInAString();
        System.out.println(solution.reverseWords(s));
    }
}
