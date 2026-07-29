package Hard;
import java.util.Stack;

public class TrappingRainWater {


    //Version #1 - Monotonic Stack
    // public int trap(int[] height) {
    //     int waterCollected = 0;

    //     Stack<Integer> stack = new Stack<>();
    //     //Iterate for loop through height
    //     for (int i = 0; i < height.length; i++) {
    //         int currentHeight = height[i];
    //         if (stack.isEmpty() || stack.peek() >= currentHeight) {
    //             stack.add(currentHeight);
    //         } else{

    //             int unitsConsumed = 0;
    //             int wallHeight = 0;

    //             while(!stack.isEmpty() && currentHeight > stack.peek()) {
    //                 printStack(stack);
    //                 System.out.println("Water collected: " + waterCollected);
    //                 unitsConsumed++;
    //                 int currentFloor = stack.pop();
    //                 while (!stack.isEmpty() && currentFloor == stack.peek()) {
    //                     unitsConsumed++;
    //                     stack.pop();
    //                 }
    //                 if (!stack.isEmpty()) {
    //          d           //Wall hit
    //                     wallHeight = Math.min(currentHeight, stack.peek());
    //                     waterCollected+= unitsConsumed * (wallHeight - currentFloor);
    //                 } else {
    //                     wallHeight = currentHeight;
    //                 }

    //             }
    //             if (!stack.isEmpty()) {
    //                 for(int j = 0; j <= unitsConsumed; j++) {
    //                     stack.add(wallHeight);
    //                 }
    //             } else {
    //                 stack.add(wallHeight);
    //             }
    //         }
    //     }

    //     return waterCollected;    
    // }

    //Version #2 - Two Pass
    public int trap(int[] height) {
        
        int waterCollected = 0;

        int[] highestWallsOnRight = new int[height.length];
        highestWallsOnRight[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            highestWallsOnRight[i] = Math.max(height[i], highestWallsOnRight[i + 1]);
        }
        
        int highestWallOnLeft = height[0];

        for (int i = 1; i < height.length - 1; i++) {
            //Get lower of two walls 
            waterCollected += Math.max(0, Math.min(highestWallOnLeft, highestWallsOnRight[i]) - height[i]);
            highestWallOnLeft = Math.max(height[i], highestWallOnLeft);
        }

        return waterCollected;
    }

    public static <T> void printStack(Stack<T> stack) {
        System.out.print("[");
        
        for (int i = 0; i < stack.size(); i++) {
            System.out.print(stack.get(i));

            if (i < stack.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        TrappingRainWater s = new  TrappingRainWater();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(height));
    }
    
}
