package Easy;

public class FindTheHighestAltitude {
    
    public int largestAltitude(int[] gain) {
        int highestAltitude = 0;
        int currentAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            currentAltitude+= gain[i];
            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }
        return highestAltitude;
    }

    public static void main(String[] args) {
        FindTheHighestAltitude s = new FindTheHighestAltitude();
        int[] gain = {-4,-3,-2,-1,4,3,2};
        System.out.println(s.largestAltitude(gain));
    }

}
