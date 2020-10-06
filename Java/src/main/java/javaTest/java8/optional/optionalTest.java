package javaTest.java8.optional;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class optionalTest {

  Logger log = LoggerFactory.getLogger(this.getClass());

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
    log.info("ㅎㅇ");

  }
}
