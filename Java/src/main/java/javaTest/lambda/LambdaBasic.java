package javaTest.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.Collectors;

public class LambdaBasic {

  public static void main(String[] args) {

    GetMaxInterface unNamedObj = new GetMaxInterface() {
      @Override
      public int max(int a, int b) {
        return a > b ? a : b;
      }
    };

    GetMaxInterface lambda1 = (int a, int b) -> a > b ? a : b;
    GetMaxInterface lambda2 = (a, b) -> a > b ? a : b;

    // 파라미터 타입을 명시하려한다면 모든 파라미터에 적용해주어야 함
//    GetMaxInterface lambda3 = (int a, b) -> a > b ? a : b;
//    GetMaxInterface lambda4 = (a, int b) -> a > b ? a : b;

    // 파라미터가 하나일때만 괄호 생략 가능
//    GetMaxInterface lambda5 = a, b -> a > b ? a : b;

    // return 연산자를 사용했을 경우 대괄호를 생략할 수 없음
//    GetMaxInterface lambda6 = (a, b) -> return a > b ? a : b;

    GetMaxInterface lambda7 = (a, b) -> {
      return a > b ? a : b;
    };

    System.out.println(unNamedObj.max(10, 5));
    System.out.println(unNamedObj.max(4, 19));

//    System.out.println(lambda.max(2, 7));
//    System.out.println(lambda.max(9, 7));

  }

  @Test
  public void T() {
  }

  // 람다식은 실제로는 익명 객체다.
  // 람다식의 매개변수, 리턴 값이 일치하면 매핑 된다.
  // 인터페이스를 통해 람다식을 다루기로 결정되었으며, 람다식을 다루는 인터페이스를 함수형 인터페이스(functional interface)라고 한다
  // 오직 하나의 추상 메서드만 정의되어 있어야한다는 제약이 있으며
  // 이 제약은 @FunctionalInterface 어노테이션으로 올바르게 정의되어 있는지 확인 할 수 있어 꼭 붙이는 것을 지향 하자.
  @FunctionalInterface
  public interface GetMaxInterface {
    int max(int a, int b);
//    String max(String a, String b);
  }

}
