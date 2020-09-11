package javaTest.java8.optional;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class optionalTest {

  Map<String, String> map;
  Map<String, String> nullMap;

  @Before
  public void setMap() {
    map = new HashMap<>();
    map.put("이름", "김은수");
    map.put("나이", "30");
  }

  @Test
  public void of() {
    Optional<Map<String, String>> opt1 = Optional.of(map);
    Optional<Map<String, String>> opt2 = Optional.ofNullable(nullMap);
    System.out.println(opt1.get().get("이름"));
  }
}
