package level1;

import java.util.Arrays;

public class WaterMelon_OK {
    public String solution(int n) {
        String answer = "";
        for(int i=1; i <= n; i ++){
            if(i % 2 == 0){
                answer += "박";
            }else{
                answer += "수";
            }
        }
        System.out.println(answer);
        return answer;
    }

    public String watermelon(int n){
        char[] c = new char [n];
        System.out.println(Arrays.toString(c));
        return new String(new char [n]).replace("\0", "수박").substring(0,n);
    }

    public static void main (String[] args) {
        WaterMelon_OK wm = new WaterMelon_OK();
        System.out.println(wm.watermelon(3));
//        wm.solution(3);
    }
}
