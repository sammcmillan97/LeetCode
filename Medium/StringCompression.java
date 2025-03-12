public class StringCompression {


    public int compress(char[] chars) {
        int i = 0;
        int j = 1;

        if(chars.length == 1) {
            return 1;
        }

        char currentLetter = chars[0];
        int currentLetterAmmount = 1;

        while(j < chars.length) {

            if (chars[j] == currentLetter) {
                currentLetterAmmount++;
            } else {
                chars[i] = currentLetter;
                i++;
                currentLetter = chars[j];
                if(currentLetterAmmount > 1) {
                    char[] ammountCharArray = ("" + currentLetterAmmount).toCharArray();
                    for(char number : ammountCharArray) {
                        chars[i] = number;
                        i++;
                    }
                }
                currentLetterAmmount = 1;
            }
            j++;
        }
        
        chars[i] = currentLetter;
        i++;
        if(currentLetterAmmount > 1) {
            char[] ammountCharArray = ("" + currentLetterAmmount).toCharArray();
            for(char number : ammountCharArray) {
                chars[i] = number;
                i++;
            }
        }

        return i;
    }



    public static void main(String[] args) {
        StringCompression solution = new StringCompression();
        char charArray[] = {'a','a','b','b','b','c'};
        System.out.println(solution.compress(charArray));
    }
}
