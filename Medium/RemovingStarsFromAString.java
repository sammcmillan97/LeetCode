import java.util.Stack;

public class RemovingStarsFromAString {

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        char[] newString  = new char[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            newString[i] = stack.pop();
        }

        return String.valueOf(newString);

    }

    public static void main(String[] args) {
        RemovingStarsFromAString s = new RemovingStarsFromAString();
        String str = "leet**cod*e";
        System.out.println(s.removeStars(str));
    }

}
