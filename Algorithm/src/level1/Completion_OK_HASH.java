package level1;

import java.util.*;

public class Completion_OK_HASH {

    public String solution (String[] participant, String[] completion) {
        String answer = "";
        Map <String, Integer> p = new HashMap<>();
        for(String player : participant){
            p.put(player, p.getOrDefault(player, -1) -1);
        }
        for(String player : completion){
            p.put(player,  p.get(player) + 1 );
        }
        for(String t : p.keySet()){
            if(p.get(t) == -2){
                answer = t;
            }
        }
        return answer;
    }


    public static void main (String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        Completion_OK_HASH c = new Completion_OK_HASH();
        c.solution(participant, completion);
    }
}
