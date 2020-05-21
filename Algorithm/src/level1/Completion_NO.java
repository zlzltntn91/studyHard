package level1;

import java.lang.reflect.Array;

public class Completion_NO {

    String[] participant = {"mislav", "stanko", "mislav", "ana"};
    String[] completion = {"stanko", "ana", "mislav"};

    public String solution (String[] participant, String[] completion) {
        String answer = "";
        first:
        for (String i : participant) {
            int count = 0;
            sec:
            for (String j : completion) {
                if (i.equals(j)) {
                    break sec;
                } else {
                    count++;
                    if(count == completion.length){
                        answer = i;
                    }
                }
            }
        }
        return answer;
    }

    public static void main (String[] args) {
        Completion_NO c = new Completion_NO();
        c.solution(c.participant, c.completion);
    }
}
