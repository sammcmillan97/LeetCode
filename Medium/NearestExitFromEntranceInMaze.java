import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {
        
        Queue<int[]> queue = new LinkedList<>();
        Set<String> visisted = new HashSet<String>();
        int[] entranceWithSteps = {entrance[0], entrance[1], 0};
        queue.add(entranceWithSteps);
        visisted.add(getCordinatesInString(entranceWithSteps));

        while(queue.size() != 0) {

            int[] currentPostion = queue.poll();
            if (maze[currentPostion[0]][currentPostion[1]] != '+') {

                //Check it isnt the entrance and its an exit return number of steps
                if (currentPostion[2] > 0 && (currentPostion[0] == 0 || currentPostion[1] == 0 || currentPostion[0] == maze.length - 1 || currentPostion[1] == maze[0].length - 1)) {
                    return currentPostion[2];
                }

                //Create up, down, left, right
                int[] up = {currentPostion[0] - 1, currentPostion[1], currentPostion[2] + 1};
                if (up[0] >= 0 && !visisted.contains(getCordinatesInString(up))) {
                    queue.add(up);
                    visisted.add(getCordinatesInString(up));
                }

                int[] down = {currentPostion[0] + 1, currentPostion[1], currentPostion[2] + 1};
                if (down[0] < maze.length && !visisted.contains(getCordinatesInString(down))) {
                    queue.add(down);
                    visisted.add(getCordinatesInString(down));
                }

                int[] left = {currentPostion[0], currentPostion[1] - 1, currentPostion[2] + 1};
                if (left[1] >= 0 && !visisted.contains(getCordinatesInString(left))) {
                    queue.add(left);
                    visisted.add(getCordinatesInString(left));

                }

                int[] right = {currentPostion[0], currentPostion[1] + 1, currentPostion[2] + 1};
                if (right[1] < maze[0].length && !visisted.contains(getCordinatesInString(right))) {
                    queue.add(right);
                    visisted.add(getCordinatesInString(right));
                }
                

            }
        }
        return -1;
    }

    public String getCordinatesInString(int[] cords) {
        return cords[0] + "," + cords[1];
    }

    public static void main(String[] args) {
        // // Maze as a 2D array of characters
        // char[][] maze = {
        //     {'+', '+', '+'},
        //     {'.', '.', '.'},
        //     {'+', '+', '+'}
        // };

        // // Entrance as a 1D array of integers
        // int[] entrance = {1, 0};
        char[][] maze = {
            {'+', '+', '+'},
            {'.', '.', '.'},
            {'+', '+', '+'}
        };

        int[] entrance = {1, 0};
        NearestExitFromEntranceInMaze s = new NearestExitFromEntranceInMaze();
        System.out.println(s.nearestExit(maze, entrance));
    }

}
