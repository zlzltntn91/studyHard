package javaTest.java8.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Lambda_Collection {

  List<Integer> list;
  Map<String, String> map;

  @Before
  public void setList() {
    list = new ArrayList<>();
    list.add(0);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);
    list.add(6);
    list.add(7);
    list.add(8);
    list.add(9);

    map = new HashMap<>();
    map.put("일", "One");
    map.put("이", "Two");
    map.put("삼", "Three");
    map.put("사", "Four");
    map.put("오", "Five");
    map.put("육", "Six");
    map.put("칠", "Seven");
    map.put("팔", "Eight");
    map.put("구", "Nine");
    map.put("십", "Ten");
    map.put("널인거", null);
  }

  /**
   * Collection
   * <p>
   * List             Set                        Map
   * <p>
   * HashMap  HashTable  SortedMap
   */

  // XXX Collection
  @Test
  public void removeIf() {
    System.out.println("요소 지우기 전 크기 : " + list.size());
    list.removeIf(x -> x.equals(5));
    System.out.println("요소 지운뒤 크기 : " + list.size());
  }

  // XXX List
  @Test
  public void replaceAll() {
    list.replaceAll((x) -> x % 2 == 0 ? 0 : 1);
    System.out.println();
    list.forEach(System.out::print);
    System.out.println();
  }

  // XXX MAP
  @Test
  public void compute() {
    // compute 계산하다
    // absent 결석, 부재
    // present 현재, 참석, 존재하는

    // compute
    map.compute("십이", (k, v) -> k + "있으면 변경, 없으면 추가");
    // computeIfAbsent
    map.computeIfAbsent("십일", (s) -> s + "없으니까 추가");
    // computeIfPresent
    map.computeIfPresent("이", (k, v) -> "있으니까 변경");

    map.forEach((k, v) -> System.out.println(k + ":" + v));
  }

  @Test
  public void merge() {
    Map<String, String> map2 = new HashMap<>();
    map2.put("일", "이치");
    map2.put("이", "니");

    map.merge("널인거", "널이라서 이걸 준비했어", (oldValue, newValue) -> newValue);
    map.merge("일", "넌 널이 아니잖아?", (oldValue, newValue) -> newValue);
    map.forEach((k, v) -> System.out.println(k + ":" + v));
  }

  @Test
  public void replaceAllByMap() {

  }

  @Test
  public void forEach() {
    map.forEach((k, v) -> System.out.println(k + ":" + v));
  }


}