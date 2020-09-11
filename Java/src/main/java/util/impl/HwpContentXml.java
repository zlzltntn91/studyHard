package util.impl;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import util.XmlParsing;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
//@Component("hwpContentXml")
public class HwpContentXml implements XmlParsing<List<Map<String, String>>> {

  @Test
  public void t() {
    String path = "C:\\odtTest\\1-국가기간 전략산업직종훈련 훈련비용 신청서(반복타입)_입력_hwp201820200909161229.009";
    File metaXml = getXmlFile(path, "content");
    NodeList nodeList = getNodeList(metaXml, "/document-content/body/text//p/span/bookmark-start");
    List<Map<String, String>> result = getResult(nodeList);
    log.info(result.toString());
  }

  @Override
  public List<Map<String, String>> getResult(NodeList list) {
    List<Map<String, String>> result = new ArrayList<>();
    Map<String, String> hashMap;
    for (int i = 0; i < list.getLength(); i++) {
      if(list.item(i).getNodeType() == Node.ELEMENT_NODE){
        Element el = (Element) list.item(i);
        log.info(el.getAttribute("text:name"));
        log.info(el.getNextSibling().getTextContent());
        hashMap = new HashMap<>();
        hashMap.put("tagName", el.getAttribute("text:name"));
        hashMap.put("tagValue", el.getNextSibling().getTextContent());
        result.add(hashMap);
      }
    }
    return result;
  }
}
