package java.test;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Slf4j
public class EtcTest {

  @Test
  public void keySet() throws ParseException {
    JSONArray jArray = new JSONArray();
    JSONParser jParser = new JSONParser();
    ArrayList<JSONObject> list = new ArrayList<>();
    String json = "[{\"tagValue\":\"testTagValue\",\"valueType\":\"string\",\"tagName\":\"testTagName\"},{\"tagValue\":\"테스트 기관\",\"valueType\":\"string\",\"tagName\":\"trAgencyName\"},{\"tagValue\":\"1\",\"valueType\":\"string\",\"tagName\":\"sNum\"},{\"tagValue\":\"테스트 과정\",\"valueType\":\"string\",\"tagName\":\"trCourseName\"},{\"tagValue\":\"T-1010\",\"valueType\":\"string\",\"tagName\":\"trCourseId\"},{\"tagValue\":\"2020-08-01\",\"valueType\":\"string\",\"tagName\":\"trPeriodFrom\"},{\"tagValue\":\"2020-08-31\",\"valueType\":\"string\",\"tagName\":\"trPeriodTo\"},{\"tagValue\":\"1회차\",\"valueType\":\"string\",\"tagName\":\"trRound\"},{\"tagValue\":\"2020-08-01\",\"valueType\":\"string\",\"tagName\":\"trUnitPeriodFrom\"},{\"tagValue\":\"2020-08-14\",\"valueType\":\"string\",\"tagName\":\"trUnitPeriodTo\"},{\"tagValue\":\"20,000,000\",\"valueType\":\"string\",\"tagName\":\"trCost\"},{\"tagValue\":\"20명\",\"valueType\":\"string\",\"tagName\":\"trCostNum\"},{\"tagValue\":\"15,000,000\",\"valueType\":\"string\",\"tagName\":\"trIncentive\"},{\"tagValue\":\"15명\",\"valueType\":\"string\",\"tagName\":\"trIncentiveNum\"}]";
    String json2 = "[{\"tagValue\":\"테스트 기관\",\"valueType\":\"string\",\"tagName\":\"trAgencyName\"},{\"tagValue\":\"1\",\"valueType\":\"string\",\"tagName\":\"sNum\"},{\"tagValue\":\"테스트 과정\",\"valueType\":\"string\",\"tagName\":\"trCourseName\"},{\"tagValue\":\"T-1010\",\"valueType\":\"string\",\"tagName\":\"trCourseId\"},{\"tagValue\":\"2020-08-01\",\"valueType\":\"string\",\"tagName\":\"trPeriodFrom\"},{\"tagValue\":\"2020-08-31\",\"valueType\":\"string\",\"tagName\":\"trPeriodTo\"},{\"tagValue\":\"1회차\",\"valueType\":\"string\",\"tagName\":\"trRound\"},{\"tagValue\":\"2020-08-01\",\"valueType\":\"string\",\"tagName\":\"trUnitPeriodFrom\"},{\"tagValue\":\"2020-08-14\",\"valueType\":\"string\",\"tagName\":\"trUnitPeriodTo\"},{\"tagValue\":\"20,000,000\",\"valueType\":\"string\",\"tagName\":\"trCost\"},{\"tagValue\":\"20명\",\"valueType\":\"string\",\"tagName\":\"trCostNum\"},{\"tagValue\":\"15,000,000\",\"valueType\":\"string\",\"tagName\":\"trIncentive\"},{\"tagValue\":\"15명\",\"valueType\":\"string\",\"tagName\":\"trIncentiveNum\"}]";
    jArray = (JSONArray) jParser.parse(json);
    JSONObject jObj = new JSONObject();
    Set<String> keySet = new HashSet<>();
    for (int i = 0; i < jArray.size(); i++) {
      jObj = (JSONObject) jArray.get(i);
      keySet.add((String) jObj.get("tagName"));
    }
    log.info(keySet.toString());
    log.info("keySize : {}", String.valueOf(keySet.size()));
    ArrayList<Map<String, String>> jsonList = new ArrayList<>();
    jsonList = (ArrayList<Map<String, String>>) jParser.parse(json2);
    log.info(jsonList.toString());
    log.info("jsonListSize : {}", String.valueOf(jsonList.size()));
    String[] keyArray = new String[keySet.size()];
    keySet.toArray(keyArray);
    ArrayList<String> valueList = new ArrayList<>();
    for (String item : keyArray) {
      String value = "";
      boolean flag = false;
      for (Map<String, String> stringStringMap : jsonList) {
        if (item.equals(stringStringMap.get("tagName"))) {
          flag = true;
          value = stringStringMap.get("tagValue");
        }
      }
      if (flag) {
        valueList.add(value);
      } else {
        valueList.add("###emptyValue###");
      }
    }
    System.out.println();
    log.info(valueList.toString());
    log.info("valueListSize : {}", String.valueOf(valueList.size()));
    for (String s : keyArray) {
      if (s.length() < 20) {
        int n = 20 - s.length();
        if (n % 2 == 1) {

          s = getSpace(n / 2) + s + getSpace(n / 2);

        } else {
          s = getSpace(n / 2) + s + getSpace(n / 2);
        }
      }
      System.out.printf("%s || ", s);
    }
    System.out.println();

    for (String value : valueList) {
      if (value.length() < 20) {
        int n = 20 - value.length();
        if (n % 2 == 1) {
          int i = getKoreanCount(value);
          if (i != 0) {
            n = n-i;
            value = getSpace(n / 2) + value + getSpace(n / 2 + 1) ;
          } else {
            value = getSpace(n / 2) + value + getSpace(n / 2 + 1) ;
          }
        } else {
          int i = getKoreanCount(value);
          if (i != 0) {
            n = n-i;
            value = getSpace(n / 2) + value + getSpace(n / 2);
          } else {
            value = getSpace(n / 2) + value + getSpace(n / 2);
          }
        }
      }
      System.out.printf("%s || ", value);
    }
  }

  @Test
  public void getKoreanCountTest() {
    String s = "랄라블랄라ㄱㄴㄷㅇㄹ";
    log.info("count : {}", getKoreanCount(s));
  }

  public int getKoreanCount(String s) {
    String korean = "[ㄱ-ㅎ가-힣]";
    String koreanConvert = s.replaceAll(korean, "_");
    char[] c = koreanConvert.toCharArray();
    int count = 0;
    for (char e : c) {
      if (String.valueOf(e).equals("_")) {
        count++;
      }
    }
    return count;
  }

  public String getSpace(int count) {
    String space = "";
    for (int i = 0; i < count; i++) {
      space += " ";
    }
    return space;
  }
}
