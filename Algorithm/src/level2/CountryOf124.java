package level2;


import java.security.spec.RSAOtherPrimeInfo;

public class CountryOf124 {

    static String answer = "";

    //MySolution
    public static String solution(int n) {
        int[] Co1 = {1, 2, 4};
        int quotient = n / 3;
        int remainder = n % 3;
        try {
            answer = Co1[remainder - 1] + answer;
            if (quotient != 0) {
                solution(quotient);
            }
        } catch (ArrayIndexOutOfBoundsException a) {
            answer = Co1[2] + answer;
            if (n > 3) {
                solution(quotient - 1);
            }
        }
        return answer;
    }

    // BestSolution
    public static String solution2(int n) {
        String[] num = {"4", "1", "2"};
        String answer = "";

        while (n > 0) {
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(2304));
        System.out.println(solution2(2304));
    }

}
