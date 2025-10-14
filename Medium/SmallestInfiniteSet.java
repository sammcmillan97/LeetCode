import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SmallestInfiniteSet {
    int current;
    PriorityQueue<Integer> next;
    Set<Integer> addedBack;

    public SmallestInfiniteSet() {
        current = 1;
        next = new PriorityQueue<>();
        addedBack = new HashSet<>();
    }
    
    public int popSmallest() {
        if(next.peek() != null) {
            int smallest = next.poll();
            addedBack.remove(smallest);
            return smallest;
        }
        return current++;
    }
    
    public void addBack(int num) {
        if (!addedBack.contains(num) && num < current) {
            addedBack.add(num);
            next.offer(num);
        }
    }

}
