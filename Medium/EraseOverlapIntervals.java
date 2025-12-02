import java.util.Arrays;

public class EraseOverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int countOfRemovals = 0;
        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));
        int edge = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            //Check for overlapping
            if (intervals[i][0] < edge) {
                countOfRemovals++;
                edge = Math.min(edge, intervals[i][1]);
            } else {
                edge = intervals[i][1];
            }
        }
        return countOfRemovals;
    }

    public static void main(String[] args) {
        EraseOverlapIntervals s = new EraseOverlapIntervals();
        int[][] intervals = new int[][] {{0,2},{1,3},{2,4},{3,5},{4,6}};
        System.out.println(s.eraseOverlapIntervals(intervals));
    }
}
