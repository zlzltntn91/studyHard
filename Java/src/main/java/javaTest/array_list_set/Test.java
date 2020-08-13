package javaTest.array_list_set;


import javaTest.PerformanceTime;

import javax.swing.*;

public class Test {

      PerformanceTime p = new PerformanceTime();

      final int LOOP_SIZE = 2_000_000_0;
      long start = 0;
      long end = 0;

      public void arrayTest(){

        long t1 = System.currentTimeMillis();
        String [] t = new String[LOOP_SIZE];

        for (int i = 0; i < LOOP_SIZE; i++) {
          t[i] = "@@@";
        }

        long t2 = System.currentTimeMillis();
        p.getPerformanceTime(t1, t2);
    }



    public static void main (String[] args) {
        Test t = new Test();
        t.arrayTest();
    }
}
