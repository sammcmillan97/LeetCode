package Easy;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    Queue<Integer> calls;
    int size;

    public RecentCounter() {
        calls = new LinkedList<>();
        size = 0;
    }
    
    public int ping(int t) {
        calls.add(t);
        size++;
        while(size != 0 && (t - calls.peek()) > 3000) {
            calls.remove();
            size--;
        }
        return size;
    }
    
}