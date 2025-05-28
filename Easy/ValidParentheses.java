package Easy;
import java.util.Stack;


public class ValidParentheses {

    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.add(current);
            } else {
                if (current == ')' && stack.peek() != '(' || current == ']' && stack.peek() != '[' || current == '}' && stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.size() == 0;
    }

}
