package Easy;

public class LongestCommonSubString {
    
    public String FindLongestCommonSubString(String str1, String str2) {
        int startOfLongestCommonString = 0;
        int offsetOfLongestCommonString = 0;

        for (int i = 0; i < str1.length(); i++) {

            for (int j = 0; j < str2.length(); j++) {

                int lengthOfCurrentString  = 0;
                int startOfCurrentString = i;
                int iIndexAtStart = i;
                int jIndexAtStart = j;

                while(str1.charAt(i) == str2.charAt(j)) {
                    lengthOfCurrentString++;
                    i++;
                    j++;

                    if (i >= str1.length() || j >= str2.length()) {
                        break;
                    }  
                }
                
                if (offsetOfLongestCommonString < lengthOfCurrentString) {
                    offsetOfLongestCommonString = lengthOfCurrentString;
                    startOfLongestCommonString = startOfCurrentString;
                }
                i = iIndexAtStart;
                j = jIndexAtStart;
            }
        }

        return str1.substring(startOfLongestCommonString, startOfLongestCommonString + offsetOfLongestCommonString);
    }
}
