package level1;

public class Days {
    public String solution(int a, int b) {
        // 4로 나눠 떨어지면 윤년
        // 4, 100 으로 나누어 떨어지면 평년
        // 4, 100, 400으로 나누어 떨어지면 윤년

        // 6                0      1      2      3      4      5      6
        String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        // 12               0    1   2   3   4   5   6   7   8   9  10  11
        int[] monthDays = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String answer = "";
        int monthDay = monthDays[a - 1];
        int day = 0;
        for (int i = 0; i < a-1; i++) {
            if(a == 1){
                day = b;
                answer = days[(b - 1 + 5) % 7];
            }else{
                day += monthDays[i];
            }
        }
        answer = days[(b - 1 + day + 5) % 7];
        System.out.println(day);
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Days d = new Days();
        d.solution(1, 25);

    }
}
