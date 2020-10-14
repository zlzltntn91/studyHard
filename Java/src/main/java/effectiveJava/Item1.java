package effectiveJava;

public class Item1 {

  /**
   * <pre>
   * 생성자 대신 정적 펙토리 메서드 (static factory method)를 고려하라.
   * 모든 프로그래머가 알아둬야 할 기법이며 생성자와 별도로 제공할 수 있다.
   *  : 클래스의 인스턴스를 반환하는 단순한 정적 메서드 (static method)
   *
   *
   * {@code
   *    public static Boolean valueOf(boolean b){
   *      return b ? Boolean.TRUE : Boolean.FALSE
   *    }
   * }
   * </pre>
   * @see java.lang.Boolean
   */
  public void description() {
  }
}
