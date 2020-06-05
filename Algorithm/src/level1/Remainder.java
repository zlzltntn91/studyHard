package level1;

import java.awt.image.BandedSampleModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Remainder {
    // Time Out
    public int solution (int n) {
        int answer = n - 1;
        for (int i = 2; i <= n; i++) {

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }

    // timeOut
    public int solution2 (int n) {
        int answer = n - 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                if (i != 2) {
                    answer--;
                }
            } else {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        answer--;
                        break;
                    }
                }
            }
        }
        return answer;
    }

    public int solution3 (int n) {
        int answer = n - 1;
        int[] d = {2, 3, 5, 7};

        Set<Integer> st = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            st.add(i);
        }
        for (int i = 0; i < d.length; i++) {
            int d2 = d[i];
            for (int j = 2; j * d2 <= n; j++) {
                st.remove(j * d2);
            }
        }
        Iterator<Integer> t = st.iterator();
        while(t.hasNext()){
            System.out.print(t.next() + " // ");
        }
        System.out.println();
        System.out.println(st);
        return st.size();
    }

    public int answer (int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int answer = 1;
        if (n >= 7) answer += 3;
        else if (n >= 5) answer += 2;
        else if (n >= 3) answer++;

        for (int i = 2; i <= n; i++) {

            if (i % 2 == 0) continue;
            else if (i % 3 == 0) continue;
            else if (i % 5 == 0) continue;
            else if (i % 7 == 0) continue;

            boolean q = false;
            if (i >= 121) {
                for (int p = 0; p < list.size(); p++) {
                    if (i < list.get(p) * list.get(p)) break;
                    if (i % list.get(p) == 0) {
                        q = true;
                        break;
                    }
                }
            }
            if (q) continue;
            answer++;
            list.add(i);

        }
        return answer;
    }

    public static void main (String[] args) {
        Remainder r = new Remainder();
        System.out.println(r.solution3(1200));
        System.out.println(r.answer(1200));
    }
}

