import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StockSpanner {

    public Stack<Integer> stack;
    public List<Integer> prices;

    public StockSpanner() {
        stack = new Stack<>();
        prices = new ArrayList<>();
        prices.add(Integer.MAX_VALUE);
        stack.add(0);
    }
    
    public int next(int price) {
        while(prices.get(stack.peek()) <= price) {
            stack.pop();
        }
        int returnValue = prices.size() - stack.peek();
        stack.add(prices.size());
        prices.add(price);
        return returnValue;
    }


    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        System.out.println(spanner.next(100));
        System.out.println(spanner.next(80));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(70));
        System.out.println(spanner.next(60));
        System.out.println(spanner.next(75));
        System.out.println(spanner.next(85));


    }

}
