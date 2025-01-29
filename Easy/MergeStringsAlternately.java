package Easy;

class MergeAlternatelySolution {
        public String mergeAlternately(String word1, String word2) {
            int i = 0; 
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while(true) {
               
               //Word 1 finsih Append remainder of word 2 
               if (i == word1.length()) {
                sb.append(word2.substring(j));
                return sb.toString();
               }
            
               //Word 2 finsih append remainder of word 1 
               if (j == word2.length()) {
                sb.append(word1.substring(i));
                return sb.toString();
               }

               if (i == j) {
                sb.append(word1.charAt(i));
                i++;
               } else {
                sb.append(word2.charAt(j));
                j++;
               }
            }
    }

    public static void main(String[] args) {
        MergeAlternatelySolution solution = new MergeAlternatelySolution();
        String word1 = "ab";
        System.out.println(word1.length());
        String word2 = "1234";
        System.out.println(solution.mergeAlternately(word1, word2));
    }
}
