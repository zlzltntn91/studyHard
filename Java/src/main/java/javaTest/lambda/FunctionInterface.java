package javaTest.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.*;

public class FunctionInterface {

  @Test
  public void runnable() {
    // 매개변수 없고 반환값도 없고
    Runnable runnable = () -> System.out.print("runnable run()");
    runnable.run();
  }

  @Test
  public void supplier() {
    // 매개변수 없이 반환값만 있음
    // supplier 공급자
    // get 받다, 얻다
    Supplier<String> supplier = () -> "supplier get()";
    System.out.println(supplier.get());
  }

  @Test
  public void accept() {
    String changeParam = "파라미터";
    changeParam = "변조된 파라미터";
//    Consumer<String> consumer = (x) -> System.out.println(changeParam); // Error:(46, 59) java: local variables referenced from a lambda expression must be final or effectively final
//    Consumer<String> consumer = System.out::println;
    String param = "파라미터";

    // Supplier 와 반대로 매개변수는 있고 반환값은 없음
    // consumer 소비자
    // accept  받아들이다
    Consumer<String> consumer = (x) -> System.out.println(x);
    consumer.accept(param);

    // 두개의 매개변수, 반환 값 없음
    // <T, R> Type, Return
    BiConsumer<String, Integer> biConsumer = (x, i) -> System.out.println(x + i);
    biConsumer.accept("하이", 3);
  }

  @Test
  public void apply() {
    // 일반적인 함수, 하나의 매개변수를 받아 반환함
    Function<String, Integer> function = x -> {
      Arrays.stream(x.split("")).forEach(System.out::print);
      return x.length();
    };




    // apply 신청하다, 지원하다, 쓰다, 적용하다
    int length = function.apply("허허허허허하하하하");
    System.out.println("\n" + length);
    // <T, U, R> Type1, Type2, Return
    BiFunction<String, String, Integer> biFunction = (stringA, stringB) -> stringA.length() + stringB.length();
    System.out.println(biFunction.apply("이 문장은 ", "몇 글자일까?"));
  }

  @Test
  public void operatorApply(){
    // unary 1항의, 단항의
    UnaryOperator<String> u = (x) -> "매개변수와 리턴타입이 같은 apply 함수, 내부적으로 Function<T, T>를 상속 받음";
    System.out.println(u.apply(""));

    BinaryOperator<String> b = (x, y) -> "매개변수 " + x  + " 와 " + y + " 의 타입이 같으며 리턴 타입도 동일하다. 내부적으로 BiFunction<T, U, R>을 상속 받는다.";
    System.out.println(b.apply("야", "호"));
  }

  @Test
  public void test() {
    // 조건식을 표현하는데 사용됨, 매개변수는 하나, 반환은 boolean
    // predicate 근거를 두다, 단정하다
    String s1 = "하이";
    String target = "호이";
    Predicate<String> predicate = x -> x.equals(target);
    System.out.printf("%s 랑 %s 랑  같냐? %b \n", s1, target, predicate.test(s1));


    // Type1, Type2
    String s2 = "야이";
    String s3 = "요이";
    BiPredicate<String, String> biPredicate = String::equals;
//    BiPredicate<String, String> biPredicate = (string1, string2) -> string1.equals(string2);
    System.out.printf("%s 랑 %s 랑  같냐? %b \n", s2, s3, biPredicate.test(s2, s3));
  }


}

