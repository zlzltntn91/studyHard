package level1;

import java.util.*;
import java.util.stream.Collectors;

public class Training_Greedy_ {
    public int solution (int n, int[] lost, int[] reserve) {

        List<List<Integer>> l = new ArrayList<>();
        List<Integer> l2 = null;
        List<Integer> l3 = new ArrayList<>(reserve.length);

        for (int i = 0; i < reserve.length; i++) {
            l3.add(reserve[i]);
        }
        for (int i = 0; i < l3.size(); i++) {
            for (int value : lost) {
                if (l3.size() != 0) {
                    if (value == l3.get(i)) {
                        l3.remove(i);
                    }
                }
            }
        }
        System.out.println(l3);
        for (int i = 0; i < l3.size(); i++) {
            l2 = new ArrayList<>();
            l2.add(l3.get(i) - 1);
            l2.add(l3.get(i) + 1);
            l.add(l2);
        }
        System.out.println(l);
        int lostStudent = lost.length;

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < l.size(); j++) {
                for (int k = 0; k < 2; k++) {
                    if (l.size() != 0) {
                        if (l.get(j).get(k) == lost[i]) {
                            l.remove(j);
                            lostStudent--;
                        }
                    }
                }
            }
        }
        System.out.println(l);
        System.out.println(n - lostStudent);
        return n - lostStudent;
    }

    public static void main (String[] args) {

        int n = 5;
        int[] lost = {2, 4, 5};
        int[] reserve = {1, 3};

        Training_Greedy_ t = new Training_Greedy_();
        t.solution(n, lost, reserve);
    }
}
