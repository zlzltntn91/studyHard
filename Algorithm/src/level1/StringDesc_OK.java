package level1;

import java.util.Arrays;
import java.util.Collections;

public class StringDesc_OK {
    public String solution(String s) {
        String answer = "";
        char [] c = s.toCharArray();
        Character [] wC = new Character[c.length];
        for (int i = 0; i < c.length; i++) {
            wC[i] = c[i];
        }
        Arrays.sort(wC, Collections.reverseOrder());
        StringBuffer sb = new StringBuffer("");
        for (int i = 0; i < wC.length; i++) {
            sb.append(wC[i]);
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main (String[] args) {
        StringDesc_OK s = new StringDesc_OK();
        String t = "Zbcdefg";
        s.solution(t);
        // gfedcbZ
    }
}
