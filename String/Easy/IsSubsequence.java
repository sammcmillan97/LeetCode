package String.Easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int currentLetter = 0;
        int i = 0;

        if (s.length() > t.length()) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        while(i < t.length()) {
            if (currentLetter >= s.length()) {
                return true;
            }
            if(s.charAt(currentLetter) == t.charAt(i)) {
                currentLetter++;
            }
            i++;
        }
        return false;
    }
}
