package String.Medium;

public class ZigzagConversion {
    
    public String convert(String s, int numRows) {
        char[] charArray = s.toCharArray();
        int currentRow = 0;
        StringBuilder sb = new StringBuilder();
        int numberToSkip =  (numRows - 1) * 2; 
        if (numRows == 1) {
            numberToSkip = 1;
        }
        int i = 0;

        while(currentRow <= numRows - 1 && i < s.length()) {
            sb.append(charArray[i]);
            while(i < s.length()) {
                if (currentRow == 0 || currentRow == numRows - 1) {
                    i+= numberToSkip;
                    if (i < s.length()) {
                         sb.append(charArray[i]);
                    }
                } else {
                    if (i + numberToSkip - (currentRow * 2) < s.length()) {
                        sb.append(charArray[i + numberToSkip - (currentRow * 2)]);
                    }
                    if (i + numberToSkip < s.length()) {
                        sb.append(charArray[i + numberToSkip]);
                    }
                    i+= numberToSkip;
                }

            }

            currentRow++;
            i = currentRow;
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
       ZigzagConversion s = new ZigzagConversion();
       String string = "A";
       System.out.println(string.length());
       String answer = s.convert(string, 2);
       System.out.println(answer.length());
       System.out.println(answer);
    }

}
