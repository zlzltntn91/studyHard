package javaTest.java8.lambda;

import java.util.Comparator;

public class LambdaComparator {

  // 하나의 메서드만 있으며 @FunctionalInterface이 선언 되어 있다.
  Comparator<String> comparator = new Comparator<String>() {
    @Override
    public int compare(String o1, String o2) {
      return o1.compareTo(o2);
    }
  };

  public static void main(String[] args) {

    LambdaComparator lc = new LambdaComparator();
    int i = lc.comparator.compare("c", "b");
    System.out.println(i);
  }

}
