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

            while(frontier.size() > 0) {
                Integer roomIndex = frontier.pop();
                if (!visited.contains(roomIndex)) {
                    
                    for(Integer room : rooms.get(roomIndex)) {
                        frontier.push(room);
                    }
                }
            }

            return visited.size() == rooms.size();
    }
}
