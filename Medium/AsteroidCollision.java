import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {

            if (stack.size() != 0) {

                while(true) {
                    if (stack.size() >= 1 && asteroid < 0) {
                        int otherAsteroid = stack.pop();
                        if (otherAsteroid > 0) {
                            if (Math.abs(otherAsteroid) > Math.abs(asteroid)) {
                                stack.add(otherAsteroid);
                                break;
                            } else if (Math.abs(asteroid) > Math.abs(otherAsteroid)) {

                            } else {
                                break;
                            }
                        } else {
                            stack.add(otherAsteroid);
                        }


                    } else {
                        stack.add(asteroid);
                        break;
                    }

                }

            } else {
                stack.add(asteroid);
            }
        }

        int size = stack.size();
        int[] array = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            System.out.println(stack.peek());
            array[i] = stack.pop();
        }
        return array;
    }


    public static void main(String[] args) {
        int[] asteroids = {8, -8};
        AsteroidCollision s = new AsteroidCollision();
        System.out.println(s.asteroidCollision(asteroids));
    }
}
