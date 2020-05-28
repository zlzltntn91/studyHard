package level1;

public class MiddleChar_OK {
    public String solution(String s) {
        char[] sList = s.toCharArray();
        int middleIndex = sList.length / 2;
        String answer = "";
        if (sList.length % 2 == 0) {
            answer += sList[sList.length / 2 -1];
            answer += sList[sList.length / 2];
        } else {
            answer = sList[sList.length / 2] + "";
        }
        return answer;
    }

    public static void main(String[] args) {
        MiddleChar_OK mc = new MiddleChar_OK();
        String s = "abcdefg";
        mc.solution(s);
    }
}
