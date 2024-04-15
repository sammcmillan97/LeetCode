import java.util.Stack;

class RemoveKdigitsSolution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        if (num.length() == k) return "0";
        for(int i = 0; i < num.length(); i++) {
            while(!stack.empty() && num.charAt(i) < stack.peek() && k > 0) {
                stack.pop();
                k--;
            }
            stack.add(num.charAt(i));
        }

        while(k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder reversedBuilder = new StringBuilder();
        
        for (int i = stack.size() - 1; i >= 0; i--) {
            reversedBuilder.append(stack.pop());
        }
        reversedBuilder.reverse();
        while(reversedBuilder.length() > 1 && reversedBuilder.charAt(0) == '0') {
            reversedBuilder.deleteCharAt(0);
        }
        return reversedBuilder.toString();
    }

    public static void main(String[] args) {
        RemoveKdigitsSolution s = new RemoveKdigitsSolution();
        System.out.println(s.removeKdigits("1432229", 4)); // 122
        System.out.println(s.removeKdigits("10200", 1)); // 200
        System.out.println(s.removeKdigits("10", 2)); // 0
        System.out.println(s.removeKdigits("194", 1)); // 14

    }
}