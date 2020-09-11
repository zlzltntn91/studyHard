package javaTest.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InitStream {

  int[] intArray;

  @Before
  public void setArrayAndList() {
    int size = 200;
    intArray = new int[size];
    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = (int) (Math.random() * size) + 1;
    }
  }

  @Test
  public void init(){
    // Collection
    List<String> list = Arrays.asList("김", "은", "수");
    Stream <String> stream = list.stream();
    stream.forEach(System.out::print);

    //

  }

  /**
   * 데이터 소스를 변경하지 않는다
   *  데이터를 읽기만할 뿐 변경하지 않는다.
   *  필요하다면 결과를 컬렉션이나 배열에 담아서 반환할 수 있다.
   */
  @Test
  public void myTest() {
    intArray = new int[10];
    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = i;
    }

//    Arrays.stream(intArray)
//      .filter(i -> i > 5)
//      .mapToObj(Function.identity())
//      .forEach(System.out::print);

    System.out.println("\n-------------");

    for (int i = 0; i < intArray.length; i++) {
      System.out.print(intArray[i]+",");
    }
    System.out.println("\n-------------");

    Arrays.stream(intArray)
      .forEach(System.out::print);
    // 6789
    // -------------
    // 0123456789
  }

  /**
   * 일회용
   * Iterator 처럼 일회용이며 필요하다면 다시 생성해야한다.
   */
  @Test
  public void reCycle() {

    intArray = new int[10];
    for (int i = 0; i < intArray.length; i++) {
      intArray[i] = i;
    }

    IntStream is = Arrays.stream(intArray);

    // IntStream -> Stream
    String t = is.filter(i -> i > 5)
      .mapToObj(String::valueOf)
      .collect(Collectors.joining(","));

    System.out.println(t);

    is.filter(i -> i > 5)
      .forEach(System.out::print); //java.lang.IllegalStateException: stream has already been operated upon or closed

    System.out.println("\n-------------");

    is.forEach(System.out::print); //java.lang.IllegalStateException: stream has already been operated upon or closed
  }

  /**
   * 내부 반복으로 처리
   * 내부 반복이란 반복문을 메서드 내에 숨길 수 있다는 것을 의미
   */
  @Test
  public void anonyus() {
  }
}
