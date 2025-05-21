import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder returnString = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == ']') {
                StringBuilder csb = new StringBuilder();

                while(stack.peek() != '[') {
                    csb.append(stack.pop());
                }
                //pop off '['
                stack.pop();

                StringBuilder isb = new StringBuilder();
                while(stack.size() != 0 && Character.isDigit(stack.peek())) {
                    isb.append(stack.pop());
                }
                isb.reverse();
                int multiplier = Integer.parseInt(isb.toString());
                csb.reverse();
                String sequence = csb.toString().repeat(multiplier);

                if (stack.size() == 0) {
                    returnString.append(sequence);
                } else {
                    //Put back onto stack
                    for (int j = 0; j < sequence.length(); j++) {
                        stack.add(sequence.charAt(j));
                    }
                }
            } else {
                stack.add(c);
            }
        }

        //Should have now consumed all brackets and be left with either an empty stack or a few characters on the stack
        if (stack.size() > 0) {
            StringBuilder csb = new StringBuilder();
            while(stack.size() != 0) {
                csb.append(stack.pop());
            }
            csb.reverse();
            String sequence = csb.toString();
            returnString.append(sequence);
        }
        return  returnString.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]10[cd]ef";
        DecodeString decoder = new DecodeString();
        System.out.println(decoder.decodeString(s));
    }
}
