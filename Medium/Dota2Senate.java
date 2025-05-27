import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        //R +1 D -1
        int score = 0;
        Queue<Character> q = new LinkedList<>();

        for (char c : senate.toCharArray()) {
            q.add(c);
        }
        int prevSize = q.size();
        while(true) {
            int countDown = prevSize;
            while(countDown-- != 0) {
                char nextSenator = q.remove();
                //R winning
                if (score > 0 && nextSenator == 'R') {
                    score++; 
                    q.add(nextSenator);
                } else if (score > 0 && nextSenator == 'D') {
                    score--;
                //D Winning    
                } else if (score < 0 && nextSenator == 'D') {
                    score--;
                    q.add(nextSenator);
                } else if (score < 0 && nextSenator == 'R') {
                    score++;
                //Score currently even    
                } else {
                    q.add(nextSenator);
                    if (nextSenator == 'R') {
                        score++;
                    } else {
                        score--;
                    }
                }
            }
            if (q.size() == prevSize) {
                //no change in size break;
                break;
            } else {
                prevSize = q.size();
            }
        }

        if (q.remove() == 'R') {
            return "Radiant";
        } else {
            return "Dire";
        }
    }

    public static void main(String[] args) {
        Dota2Senate s = new Dota2Senate();
        String senate = "RDDR";
        System.out.println(s.predictPartyVictory(senate));
    }
}
