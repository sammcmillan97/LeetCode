package Array.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer, Integer> indexes;
    ArrayList<Integer> numbers;
    Random r = new Random();

    public RandomizedSet() {
        indexes = new HashMap<>();
        numbers = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(!indexes.containsKey(val)) {
            numbers.add(val);
            indexes.put(val, numbers.size() - 1);
            return true;
        } else {
            return false;
        }

    }
    
    public boolean remove(int val) {
        if(indexes.containsKey(val)) {
            int indexOfRemoved = indexes.get(val);
            int endNumber = numbers.get(numbers.size() - 1);

            numbers.set(indexOfRemoved, endNumber);
            indexes.put(endNumber, indexOfRemoved);

            numbers.remove(numbers.size() - 1);
            indexes.remove(val);
            
            return true;
        } else {
            return false;
        }

    }
    
    public int getRandom() {
        return numbers.get(this.r.nextInt(numbers.size() - 1));
    }

    public static void main(String[] args) {
        RandomizedSet s = new RandomizedSet();
        s.insert(-20);
        s.insert(-47);
        s.remove(-20);
        s.remove(-47);
    }

}
