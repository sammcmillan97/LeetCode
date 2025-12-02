import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combineRecurse(1, k, n, new ArrayList<>(), result);
        return result;
    }

    public void combineRecurse(int start, int k, int remaining, List<Integer> digits, List<List<Integer>> result) {
        if (digits.size() == k) {
            if (remaining == 0) {
                result.add(new ArrayList<>(digits));
            }
            return;
        }

        for(int i = start; i <= 9; i++) {
            if (i > remaining) break; 
            digits.add(i);
            combineRecurse(i + 1, k, remaining - i, digits, result);
            digits.remove(digits.size() - 1); //backtrack
        }
        return;
    }

    public static void main(String[] args) {
        CombinationSum3 s = new CombinationSum3();
        System.out.println(s.combinationSum3(3, 24));
    }
}
