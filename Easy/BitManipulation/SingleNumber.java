package Easy.BitManipulation;

public class SingleNumber {

    //O(n) solution
    public int singleNumber(int[] nums) {
        int imposter = 0;
        for(int num : nums) {
            imposter= imposter ^ num;
        }
        return imposter;
    }

    public static void main(String[] args) {
        
    }

}
