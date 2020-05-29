package level1;

public class Remainder {
    public int solution(int n) {
        int answer = 1;
        String temp = "";
        for (int i = 10; i <= n; i++) {
            if( i == 3 ){
                answer ++;
                continue;
            }
            if( i % 2 != 0){
                if(i % 3 != 0) {
                    temp += i +"/";
                    answer++;
                }
            }
        }
        System.out.println(temp);
        System.out.println(answer);
        return answer;
    }

    public static void main (String[] args) {
        Remainder r = new Remainder();
        // 1,2,3,4,5            // 2,3,5
        // 1,2,3,4,5,6,7,8,9,10 // 2,3,5,7
        r.solution(12);
    }
}
