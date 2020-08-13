package javaTest.lambda;

import org.junit.Test;

import java.util.function.ObjDoubleConsumer;

public class PrimaryTypeFunctionInterface {

  // Double, Int, Long
  // A To B
  @Test
  public void doubleToIntFunction(){

  }

  // To B
  @Test
  public void toIntFunction(){

  }

  // A
  @Test
  public void intFunction(){

  }

  // Obj To A
  @Test
  public void objIntConsumer(){
    ObjDoubleConsumer<Integer> objDoubleConsumer = (t, a) -> {System.out.println(t); System.out.println(a);};
    objDoubleConsumer.accept(3, 1.2);
  }
}
