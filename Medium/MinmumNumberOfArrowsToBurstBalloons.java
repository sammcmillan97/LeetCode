import java.util.Arrays;

public class MinmumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (x,y) -> Integer.compare(x[0], y[0]));
        int newGroup = 1;
        int r = points[0][1];
        
        for(int i = 1; i < points.length; i++) {

            if (points[i][0] <= r) {
                r = Math.min(r, points[i][1]);
            } else{
                r = Math.max(r, points[i][1]);
                newGroup++;
            }

        }
        return newGroup;
    }

    public static void main(String[] args) {
        int[][] points = {{7,15},{6,14},{8,12},{3,4},{4,13},{6,14},{9,11},{6,12},{4,13}};
        MinmumNumberOfArrowsToBurstBalloons s = new MinmumNumberOfArrowsToBurstBalloons();
        System.out.println(s.findMinArrowShots(points));
    }

}
