import java.util.HashMap;
import java.util.Map;

public class DominoAndTrominoTiling {

    private static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        Map<Integer, Long> cache = new HashMap<>();
        cache.put(1, 1L);
        cache.put(2, 2L);
        cache.put(3, 5L);
        return (int) recurseNumTilings(cache, n);
    } 

    public long recurseNumTilings(Map<Integer , Long> cache, int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        long part1 = (recurseNumTilings(cache, n - 1) * 2) % MOD;
        long part2 = recurseNumTilings(cache, n - 3) % MOD;
        long returnValue = (part1 + part2) % MOD;

        cache.put(n, returnValue);
        cache.put(n, returnValue);
        return returnValue;

    }

    public static void main(String[] args) {
        DominoAndTrominoTiling s = new DominoAndTrominoTiling();
        System.out.println(s.numTilings(30));


    }

}
