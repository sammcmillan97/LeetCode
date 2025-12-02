import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] daysUntilWarmerTemprerture = new int[temperatures.length];


        for(int i = temperatures.length - 1; i >= 0; i--) {
            int currentTemp = temperatures[i];
            int indexOfWarmerTemp = 0;
            while(stack.size() != 0 && temperatures[stack.peek()] < currentTemp) {
                stack.pop();    
            }
            if (stack.size() != 0) {
                indexOfWarmerTemp = stack.peek() - i;
            }
            stack.addFirst(i);
            daysUntilWarmerTemprerture[i] = indexOfWarmerTemp;

        }
        return daysUntilWarmerTemprerture;
    }

    public static void main(String[] args) {
        DailyTemperatures s = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] results = s.dailyTemperatures(temperatures);
        for(int days : results) {
            System.out.println(days);
        }
    }
}
