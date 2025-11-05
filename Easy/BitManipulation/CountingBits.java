package Easy.BitManipulation;

public class CountingBits {

    //Brute Force solution nlogn
    // public int[] countBits(int n) {
    //     int[] numberOfBits = new int[n + 1];

    //     for(int i = 0; i <= n; i++) {
    //         int count = 0;
    //         int num = i;
    //         while(num != 0) {
    //             count += num & 1;
    //             num = num >> 1;
    //         }
    //         numberOfBits[i] = count;
    //     }
    //     return numberOfBits;
    // }

    //Dynamic programing n
    public int[] countBits(int n) {
        int[] numberOfBits = new int[n + 1];
        int significantBit = 1;
        for(int i = 1; i <= n; i++) {

            if (significantBit * 2 == i) {
                significantBit = i;
            }

            numberOfBits[i] = 1 + numberOfBits[i - significantBit];
        }
        return numberOfBits;
    }

    public static void main(String[] args) {
        CountingBits s = new CountingBits();
        int[] solution = s.countBits(10);
        for(int count : solution) {
            System.out.println(count);
        }
    }

}
