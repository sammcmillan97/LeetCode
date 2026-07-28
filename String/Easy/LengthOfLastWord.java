
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        char[] charArray = s.toCharArray();
        int endOfString = charArray.length -1;

        while(s.charAt(endOfString) == ' ') {
            endOfString--;
        }

        int startOfString = endOfString;
        while(startOfString >= 0 && s.charAt(startOfString) != ' ') {
            startOfString--;
        }
        
        return endOfString - startOfString;
    }

    public static void main(String[] args) {
        LengthOfLastWord s = new LengthOfLastWord();
        String one = "   fly me   to   the moon  ";
        String two = "luffy is still joyboy";
        String three = "A ";
        String four = " A";
        String five = "A";

        System.out.println(s.lengthOfLastWord(five));
        System.out.println(s.lengthOfLastWord(four));
        System.out.println(s.lengthOfLastWord(three));

    }
}
