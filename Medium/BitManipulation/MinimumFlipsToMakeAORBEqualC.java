package BitManipulation;

public class MinimumFlipsToMakeAORBEqualC {

    public int minFlips(int a, int b, int c) {
        
        int count = 0;
        while(a != 0 || b != 0 || c != 0) {

            int aBit = 1 & a;
            int bBit = 1 & b;
            int cBit = 1 & c;
            if (cBit == 1) {
                if (aBit == 0 && bBit == 0) {
                    count++;
                }
            } else {
                count+= aBit + bBit;
            }
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }

        return count;
    }

}
