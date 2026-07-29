package Easy;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String commonPrefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for(int j = 0; j < strs.length; j++) {
                String currentString = strs[j];
                if (currentString.length() - 1 < i || currentString.charAt(i) != strs[0].charAt(i)) {
                    return commonPrefix;
                }
            }
            commonPrefix+= strs[0].charAt(i);
        }   
        return commonPrefix; 
    }

    public static void main(String[] args) {
        LongestCommonPrefix s = new LongestCommonPrefix();
        String[] strs = {"dog", "racecar", "car"}; 
        System.out.println(s.longestCommonPrefix(strs));
    }
}
