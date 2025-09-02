import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Set<Integer> visited = new HashSet<Integer>();
        Stack<Integer> frontier = new Stack<Integer>();

        for(Integer room : rooms.get(0)) {
            frontier.push(room);
        }

        visited.add(0);

        while(frontier.size() > 0) {
            Integer roomIndex = frontier.pop();
            if (!visited.contains(roomIndex)) {

                visited.add(roomIndex);
                for(Integer room : rooms.get(roomIndex)) {
                    if (!visited.contains(room)) {
                        frontier.push(room);
                    }
                }
            }
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        KeysAndRooms s = new KeysAndRooms();
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList(1, 3));
        listOfLists.add(Arrays.asList(3, 0, 1));
        listOfLists.add(Arrays.asList(2));
        listOfLists.add(Arrays.asList(0));


        // listOfLists.add(Arrays.asList(1));
        // listOfLists.add(Arrays.asList(2));
        // listOfLists.add(Arrays.asList(3));
        // listOfLists.add(Collections.emptyList()); // []

        System.out.println(s.canVisitAllRooms(listOfLists));
    }
}
