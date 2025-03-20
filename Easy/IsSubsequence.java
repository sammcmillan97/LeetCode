package Easy;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int j = 0;
        int i = 0;
        while(i < t.length() && j < s.length()) {
            if(s.charAt(j) == t.charAt(i)) {
                j++;
            }
            i++;
        }
        return (j == s.length());
    }

    public static void main(String args[]) {
          IsSubsequence soultion = new IsSubsequence();
          String s  = "";
          String t = "ahbgdc";
          System.out.println(soultion.isSubsequence(s, t)   );
    }
}
