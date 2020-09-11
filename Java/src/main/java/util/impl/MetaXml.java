package util.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.XmlParsing;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Slf4j
//@Component("metaXml")
public class MetaXml implements XmlParsing<Map<String, String>> {

  @Test
  public void test() {
    String path = "D:\\uploadTest\\국가기간 전략산업직종훈련 위탁계약 체결 요청서(변수_입력)20200904094735909";
    File metaXml = getXmlFile(path, "meta");
    NodeList nodeList = getNodeList(metaXml, "/document-meta/meta");
    Map<String, String> result = getResult(nodeList);
    result.keySet().forEach(key -> System.out.println(key + " : " + result.get(key)));
  }

  @Override
  public Map<String, String> getResult(NodeList list) {
    Map<String, String> result = new HashMap<>();
    for (int i = 0; i < list.getLength(); i++) {
      Node node = list.item(i);
      if (node.hasChildNodes()) {
        for (int j = 0; j < node.getChildNodes().getLength(); j++) {
          if (node.getChildNodes().item(j).getNodeName().equals("meta:generator")) {
            result.put("generator", node.getChildNodes().item(j).getTextContent());
          }else if(node.getChildNodes().item(j).getNodeName().equals("meta:initial-creator")) {
            result.put("initialCreator", node.getChildNodes().item(j).getTextContent());
          }
        }
      }
    }
    return result;
  }
}
