package level1;

import java.util.Arrays;

public class MockExam {
    // 12345
    // 21232425
    // 3311224455
    /*
    시험은 최대 10,000 문제로 구성되어있습니다.
    문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
    가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
    */
    public int [] solution(int [] answers){
        int [] answer = new int[0];
        int [] a, b, c = null;

        a = new int[] {1,2,3,4,5}; // 5
        b = new int[] {2,1,2,3,2,4,2,5}; //5
        c = new int[] {3,3,1,1,2,2,4,4,5,5};

        int answerLength = answers.length;


        boolean collectA;
        boolean collectB;
        boolean collectC;
        int bA, bB, bC;
        bA = 0;
        bB = 0;
        bC = 0;



        for (int i = 0; i < answerLength; i++) {
            if(i > a.length-1){
                String sLength = i+""; // 5, 6, 7, 8
                char lastNum = sLength.charAt(sLength.length()-1); // 5, 6, 7, 8
                int iNum = Integer.parseInt(String.valueOf(lastNum)); // 5
                System.out.println( i + " // " + (a.length-iNum));
                collectA = answers[i] == a[Math.abs(a.length-iNum)];
            }else{
                collectA = answers[i] == a[i];
            }
//            collectB = answers[i] == b[iNum];
//            collectC = answers[i] == c[iNum];

            if(collectA){
                bA++;
//            }else if(collectB){
//                bB++;
//            }else if(collectC){
//                bC++;
            }
        }
        return answer;
    }
    public static void main (String[] args) {
        int [] answers1 = {1,2,3,4,5,1,2,3,4,1,2,3,4,5,6,7};
        int [] answers2 = {1,3,2,4,2};
        MockExam me = new MockExam();
        me.solution(answers1);
        // return [1] , [1,2,3]
    }
}
