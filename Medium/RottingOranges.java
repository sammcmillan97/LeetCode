import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();    
        int total = 0;
        int visistedNodes= 0;
        int[][] dirs= {{1,0},{0,1},{0,-1},{-1,0}};
        int rowUpperBound = grid.length -1;
        int coloumnUpperBound = grid[0].length -1;

        //Loop through get starting points (rotten oranges), get total number of oranges
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    total++;
                }
                else if (grid[i][j] == 2) {
                    total++;
                    visistedNodes++;
                    queue.add(new int[]{i, j});
                }
            }
        }

        int minutes = 0;
        //Start a loop keep looping while new queue has something it 
        while(true) {
            
            Queue<int[]> newQueue = new LinkedList<>(); 

            while(queue.size() != 0) {

                int[] currentIndex = queue.poll();
                int cr = currentIndex[0];
                int cc = currentIndex[1];

                for (int[] dir: dirs) {
                    int nr = cr + dir[0];
                    int nc = cc + dir[1];

                    //Check if new postion is not out of bound and it is a fresh orange
                    if(nr >= 0 && nr <= rowUpperBound && nc >= 0 && nc <= coloumnUpperBound && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        visistedNodes++;
                        newQueue.add(new int[]{nr, nc});
                    }
                }

            }
            if (newQueue.size() == 0) {
                break;
            }
            queue = newQueue;
            minutes++;
        }

        //loop through queue and run BFS on each node 
        //put new nodes into new queue and count visited nodes 
        //set fresh oranges to rotten on grid
        //Count each loop, each loop is a minute 
        //If queue has anything in it contiune else break 

        //If visisted nodes == total return minutes else return -1
        if (visistedNodes == total) {
            return minutes;
        } else {
            return -1;
        }
    }


    public static void main(String[] args) {
        RottingOranges s = new RottingOranges();
        int[][] grid = new int[][]{ {2,1,1}, 
                                    {1,1,0}, 
                                    {0,1,1}};
        System.out.println(s.orangesRotting(grid));
    }

}
