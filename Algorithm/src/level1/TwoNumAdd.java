package level1;

public class TwoNumAdd {
    public long solution(int a, int b) {
        long answer = 0;

        int bigNum = Math.max(a, b);
        int smallNum = Math.min(a, b);

        for (int i = smallNum; i <= bigNum; i++) {
            answer += smallNum++;
        }

        return answer;
    }

    public static void main (String[] args) {
        TwoNumAdd tna = new TwoNumAdd();
        int a, b;
        a = 3;
        b = 5;
        System.out.println(tna.solution(a, b));

    }
}
