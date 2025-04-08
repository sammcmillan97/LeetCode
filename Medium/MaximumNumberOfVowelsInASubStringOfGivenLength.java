public class MaximumNumberOfVowelsInASubStringOfGivenLength {
    public int maxVowels(String s, int k) {
        int numberOfVowelsInWindow = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                numberOfVowelsInWindow++;
            }
        }
        int currentBiggest = numberOfVowelsInWindow;
        for (int i = 0; i + k < s.length(); i++) {
            if (isVowel(s.charAt(i))) {
                numberOfVowelsInWindow--;
            }
            if (isVowel(s.charAt(i + k))) {
                numberOfVowelsInWindow++;
            }

            if (numberOfVowelsInWindow  > currentBiggest) {
                currentBiggest = numberOfVowelsInWindow;
            }
        }

        return currentBiggest;
    }

    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c); 
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
    }

    public static void main(String[] args) {
        MaximumNumberOfVowelsInASubStringOfGivenLength s = new MaximumNumberOfVowelsInASubStringOfGivenLength();
        String str = "leetcode";
        int k = 3;
        System.out.println(s.maxVowels(str, k));
    }

}
