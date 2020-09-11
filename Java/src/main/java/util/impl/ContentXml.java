package util.impl;

import org.junit.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import util.XmlParsing;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Component("contentXml")
public class ContentXml implements XmlParsing<List<Map<String, String>>> {

  @Test
  public void test() {
    String path = "C:\\Users\\dgtazm9513\\Desktop\\Dzone_project\\ODF\\6-[별지 제21호서식] 보조기기 급여비 지급청구서 - 복사본";
    File metaXml = getXmlFile(path, "content");
    NodeList nodeList = getNodeList(metaXml, "/office:body/office:text/");
    List<Map<String, String>> result = getResult(nodeList);
    log.info(result.toString());
  }

  @Override
  public List<Map<String, String>> getResult(NodeList list) {
    List<Map<String, String>> result = new ArrayList<>();
    Map<String, String> map;
    for (int i = 0; i < list.getLength(); i++) {
      map = new HashMap<>();
      Element ele = (Element) list.item(i);
      String key = ele.getAttribute("text:name");
      String valueType = ele.getAttribute("office:value-type");
      String valuTypeAppendValue = "office:" + valueType + "-value";
      String value = ele.getAttribute(valuTypeAppendValue);
      map.put("tagName", key);
      map.put("tagValue", value);
      map.put("valueType", valueType);
      result.add(map);
    }
    return result;
  }
}
