package level1;


import java.security.spec.RSAOtherPrimeInfo;

public class CountryOf124 {


    public static String solution(int n) {
        //124
        String answer = "";

        int [] Co1 = {1, 2, 4};

        int i = n / 3;
        int j = n % 3;

        // 1 자리수
        if(String.valueOf(n).length() == 1){
            answer = String.valueOf(Co1[n-1]);

        }else{

        }
        System.out.println(answer);
        return answer;
    }

    public static void main (String[] args) {

        solution(5);
    }

}
