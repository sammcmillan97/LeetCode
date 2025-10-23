package Easy;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber {

    public int tribonacci(int n) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 0);
        cache.put(1, 1);
        cache.put(2, 1);
        tribonacciRecurse(n, cache);
        return cache.get(n);
    }

    public int tribonacciRecurse(int n,  Map<Integer, Integer> cache ) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = tribonacciRecurse(n - 3, cache) + tribonacciRecurse(n - 2, cache) + tribonacciRecurse(n - 1, cache);
        cache.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        NthTribonacciNumber s = new NthTribonacciNumber();
        System.out.println(s.tribonacci(25));
    }
}
