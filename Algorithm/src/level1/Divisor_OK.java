package level1;

import java.util.*;

public class Divisor_OK {

    public int[] solution(int[] arr, int divisor) {
        Integer [] answer = {};
        List<Integer> list = new ArrayList<>();
        for (int i : arr){
            if( i % divisor == 0){
                list.add(i);
            }
        }
        if(list.size() == 0) list.add(-1);
        answer = list.toArray(new Integer[list.size()]);
        int [] ar = new int [answer.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = answer[i];
        }
        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));
        return ar;
    }

    public static void main (String[] args) {
        Divisor_OK d = new Divisor_OK();
        int [] arr = {5, 9, 15, 17, 10};
        int divisor = 5;
        d.solution(arr, divisor);
    }
}
