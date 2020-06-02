package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MockExam_OK {
    // 12345
    // 21232425
    // 3311224455
    /*
    시험은 최대 10,000 문제로 구성되어있습니다.
    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    */
    public int[] solution (int[] answers) {

        int[] a, b, c = null;
        int aa, bb, cc;
        a = new int[]{1, 2, 3, 4, 5}; // 5
        b = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; //5
        c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        aa = 0;
        bb = 0;
        cc = 0;
        for (int i = 0; i < answers.length; i++) {
            if (a[i % a.length] == answers[i]) {
                aa++;
            }
            if (b[i % b.length] == answers[i]) {
                bb++;
            }
            if (c[i % c.length] == answers[i]) {
                cc++;
            }
        }
        int[] answer = new int[]{aa, bb, cc};
        int bigNum = Math.max(Math.max(aa, bb), Math.max(bb, cc));
        List<Integer> realAnswer = new ArrayList<>();
        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == bigNum){
                realAnswer.add(i+1);
            }
        }
        int [] ra = new int[realAnswer.size()];
        for (int i = 0; i < realAnswer.size(); i++) {
            ra[i] = realAnswer.get(i);
        }
        System.out.println(Arrays.toString(ra));
        return ra;
    }


    public static void main (String[] args) {
        int[] answers1 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5,1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
        int[] answers2 = {1, 3, 2, 4, 2};
        MockExam_OK me = new MockExam_OK();
        me.solution(answers1);
    }
}
