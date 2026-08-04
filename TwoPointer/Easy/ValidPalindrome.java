public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r) {
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }

            while(l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }

            if (l < r && Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome s = new ValidPalindrome();
        String str = "A man, a plan, a canal: Panama";
        System.out.println(s.isPalindrome(str));
    }
}
