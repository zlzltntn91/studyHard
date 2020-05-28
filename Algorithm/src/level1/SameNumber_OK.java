package level1;

import java.util.ArrayList;

public class SameNumber_OK {
    public int [] solution(int []arr) {
        ArrayList <Integer> answer = new ArrayList<>();

        answer.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if(arr[i-1] != arr[i]){
                answer.add(arr[i]);
            }
        }
        int [] l = new int [answer.size()];
        for (int i = 0; i < l.length; i++) {
            l[i] = answer.get(i);
        }
        return l;
    }

    public static void main (String[] args) {
        SameNumber_OK sm = new SameNumber_OK();
        int [] arr1 = {1,1,3,3,0,1,1};
        int [] arr2 = {4,4,4,3,3,3,1};
        sm.solution(arr2);
    }
}
