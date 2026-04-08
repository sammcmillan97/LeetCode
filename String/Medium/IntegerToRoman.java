package String.Medium;

public class IntegerToRoman {
    
    int[] integers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while(i <= 12 ) {
            while( 0 <= (num - integers[i])) {
                sb.append(romans[i]);
                num -= integers[i];
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman s = new IntegerToRoman();
        int num = 58;
        System.out.println(s.intToRoman(num));
    }
}
