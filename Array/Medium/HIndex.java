package Array.Medium;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hIndex = 0;
        for(int i = 0; i < citations.length; i++) {
            if (citations[i] > citations.length - i) {
                return Math.max(hIndex, citations.length - i);
            }
            hIndex = citations[i];
        }
        return hIndex;
    }

    public static void main(String[] args) {
        HIndex s = new HIndex();
        int[] citations = {3,0,6,1,5};
        System.out.println(s.hIndex(citations));
    }

}
