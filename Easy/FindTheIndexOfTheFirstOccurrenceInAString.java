package Easy;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
       
        int l =0;
        int r =0;
        char[] hayArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        if (needleArray.length > hayArray.length) {
            return -1;
        }
        while(l <= hayArray.length - 1) {
            r = l;
            for (int i = 0; i < needleArray.length && r < hayArray.length; i++) {
                if (hayArray[r] != needleArray[i]) {
                    break;
                } 
                if (i == needleArray.length - 1) {
                    return l;
                }
                r++;
            }
            l++;  
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString s = new FindTheIndexOfTheFirstOccurrenceInAString();
        String haystack = "mississippi";
        String needle = "issipi";
        System.out.println(s.strStr(haystack, needle));
    }
}
