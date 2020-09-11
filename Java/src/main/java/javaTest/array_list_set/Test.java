package javaTest.array_list_set;


import makeSoo.PerformanceTime;

import java.util.*;

public class Test {

  final int LOOP_SIZE = 2_000_000;
  PerformanceTime p = new PerformanceTime();
  long start = 0;
  long end = 0;

  public static void main(String[] args) {
    Test t = new Test();
    t.arrayTest();
    t.setTest();
    t.listTest();
    t.linkedTest();
  }

  public void arrayTest() {
    long t1 = System.currentTimeMillis();
    String[] t = new String[LOOP_SIZE];
    for (int i = 0; i < LOOP_SIZE; i++) {
      t[i] = "@@@";
    }
    long t2 = System.currentTimeMillis();
    p.getPerformanceTime(t1, t2, "Array Add Asc");

    long t3 = System.currentTimeMillis();
    for (int i = 0; i < LOOP_SIZE; i++) {
      String res = t[i];
    }
    long t4 = System.currentTimeMillis();
    p.getPerformanceTime(t3, t4, "Array Get Asc");
  }

  public void setTest(){
    long t1 = System.currentTimeMillis();
    Set<String> list = new HashSet<>();
    for (int i = 0; i < LOOP_SIZE; i++) {
      list.add("@@@");
    }
    long t2 = System.currentTimeMillis();
    p.getPerformanceTime(t1, t2, "HashSet Add");
  }

  public void listTest(){
    long t1 = System.currentTimeMillis();
    List<String> list = new ArrayList<>();
    for (int i = 0; i < LOOP_SIZE; i++) {
      list.add("@@@");
    }
    long t2 = System.currentTimeMillis();
    p.getPerformanceTime(t1, t2, "ArrayList Add");
  }

  public void linkedTest(){
    long t1 = System.currentTimeMillis();
    List<String> list = new LinkedList<>();
    for (int i = 0; i < LOOP_SIZE; i++) {
      list.add("@@@");
    }
    long t2 = System.currentTimeMillis();
    p.getPerformanceTime(t1, t2, "LinkedList Add");
  }
}
