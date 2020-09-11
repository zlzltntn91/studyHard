package util.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import util.XmlParsing;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//@Component("contentMultipleXml")
public class ContentMultipleXml implements XmlParsing<Map<String, List<String>>> {

  /**
   * Test.
   */
  @Test
  public void test() {
    String path = "C:\\odtTest\\1-국가기간 전략산업직종훈련 훈련비용 신청서(반복타입)_입력20200908145845.302";
    File metaXml = getXmlFile(path, "content");
    NodeList nodeList = getNodeList(metaXml, "/document-content/body/text//p/text-input");
    Map<String, List<String>> result = getResult(nodeList);
    ObjectMapper mapper = new ObjectMapper();
    try {
      log.info(mapper.writeValueAsString(result));
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
  }

  @Override
  public Map<String, List<String>> getResult(NodeList list) {
    Map<String, List<String>> multiValueMap = new LinkedMultiValueMap<>();

    for (int i = 0; i < list.getLength(); i++) {
      Element ele = (Element) list.item(i);
      String description = ele.getAttribute("text:description");
      multiValueMap.put(description, new ArrayList<>());
    }

    String[] keyArray = new String[multiValueMap.size()];
    multiValueMap.keySet().toArray(keyArray);

    log.info(Arrays.toString(keyArray));
    log.info(multiValueMap.toString());

    String description = "";
    List<String> valueList = new ArrayList<>();
    for (int j = 0; j < list.getLength(); j++) { // 24
      Element ele = (Element) list.item(j);
      description = ele.getAttribute("text:description");
      for (int i = 0; i < keyArray.length; i++) { // 12
        if (keyArray[i].equals(description)) {
          multiValueMap.computeIfPresent(description, (String k, List<String> v) -> {
            v.add(ele.getTextContent());
            return v;
          });
        }
      }
    }
    log.info(multiValueMap.toString());
    return multiValueMap;
  }
}
