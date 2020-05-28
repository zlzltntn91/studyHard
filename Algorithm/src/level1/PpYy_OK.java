package level1;

public class PpYy_OK {
    boolean solution(String s) {
        boolean answer = true;
        char [] c = s.toCharArray();
        int p = 0;
        int y = 0;
        for (int i = 0; i < c.length ; i++) {
            String temp = c[i]+"";
            if (temp.equalsIgnoreCase("P")){
                p++;
            }
            if(temp.equalsIgnoreCase("Y")){
                y++;
            }
        }
        if(p!=y){
            answer = false;
        }
        return answer;
    }
}
