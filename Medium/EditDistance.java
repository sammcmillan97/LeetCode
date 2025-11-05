public class EditDistance {

    public int minDistance(String word1, String word2) {
        
        int[][] values = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            values[i][word2.length()] = word1.length() - i;
        }
        for (int i = 0; i < word2.length(); i++) {
            values[word1.length()][i] = word2.length() - i;

        }

        for(int i = values.length - 2; i >= 0; i--) {
            for (int j = values[0].length - 2; j >= 0; j--) {

                if (word1.charAt(i) == word2.charAt(j)) {
                    values[i][j] = values[i + 1][j + 1];
                } else {
                    values[i][j] = 1 + Math.min(values[i + 1][j + 1], Math.min(values[i + 1][j], values[i][j + 1]));
                }

            }
        }

        // printMatrix(values);
        return values[0][0]; 
    }


    public void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j] + ",");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        EditDistance s = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(s.minDistance(word1, word2));
    }

}
