package level1;

import java.util.*;

public class SortStringMymind_OK {
    public String[] solution (String[] strings, int n) {
        String[] answer = new String[strings.length];
        Map<String, Character> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            answer[i] = strings[i].charAt(n)+"^"+strings[i];
        }
        Arrays.sort(answer);
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer[i].substring(answer[i].indexOf("^")+1);
        }
        return answer;
    }

    public static void main (String[] args) {
        SortStringMymind_OK s = new SortStringMymind_OK();
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        s.solution(strings, n);
    }
}
