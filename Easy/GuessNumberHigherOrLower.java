package Easy;

public class GuessNumberHigherOrLower {

    public int pick;

    GuessNumberHigherOrLower(int pick) {
        this.pick = pick;
    }


    public int guessNumber(int n) {
        int result = -1;
        int lowerbound = 0;
        int upperBound = n;
        int guess = lowerbound + Math.ceilDiv(upperBound - lowerbound, 2);
        while(result != 0) {
            result = guess(guess);
            if (result == 0) {
                return guess;
            }
            if (result == -1 ) {
                upperBound = guess;
            }
            if (result == 1) {
                lowerbound = guess;
            }
            guess = lowerbound + Math.ceilDiv(upperBound - lowerbound, 2);
        }
        return guess;
    }

    private int guess(int num) {
        if (num == this.pick) {
            return 0;
        }

        if (num > this.pick) {
           return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {

        GuessNumberHigherOrLower s = new GuessNumberHigherOrLower(1);
        System.out.println(s.guessNumber(2));
    }
}
