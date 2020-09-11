package util;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public interface XmlParsing<T> {

  Logger log = LoggerFactory.getLogger(XmlParsing.class);

  default File getXmlFile(String path, String xmlFileName) {
    log.info("########## path : {}", path);
    log.info("########## xmlFileName : {}", xmlFileName);
    File unzipFolder = new File(path);
    log.info("unzipFolder exist? :{}", unzipFolder.exists());
    FileFilter fileFilter = new WildcardFileFilter("*.xml");
    File[] list = unzipFolder.listFiles(fileFilter);
    list = Optional.ofNullable(list).orElse(new File[]{});
    log.info(".xml File Count : {}", list.length);
    Optional<File> xmlFile = Arrays.stream(list).filter(f -> f.getName().equals(xmlFileName + ".xml")).findFirst();
    return xmlFile.get();
  }

  default NodeList getNodeList(File xmlFile, String expression) {
    Document doc;
    DocumentBuilder builder;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

//    factory.setNamespaceAware(true);

    log.info("nameSpaceAware: {}", factory.isNamespaceAware());

    NodeList nodeList = null;
    try (FileInputStream fis = new FileInputStream(xmlFile)) {

      InputSource is = new InputSource(fis);
      builder = factory.newDocumentBuilder();
      doc = builder.parse(is);

      XPath xpath = XPathFactory.newInstance().newXPath();
//      xpath.setNamespaceContext(new NamespaceContext() {
//        @Override
//        public String getNamespaceURI(String prefix) {
//          return prefix.equals("office") ? "urn:oasis:names:tc:opendocument:xmlns:office:1.0" : null;
//        }
//
//        @Override
//        public String getPrefix(String namespaceURI) {
//          return null;
//        }
//
//        @Override
//        public Iterator getPrefixes(String namespaceURI) {
//          return null;
//        }
//      });
      XPathExpression xPathExpression = xpath.compile(expression);
      nodeList = (NodeList) xPathExpression.evaluate(doc, XPathConstants.NODESET);

      log.info("nodeLength : {}", nodeList.getLength());
    } catch (IOException | XPathExpressionException | SAXException | ParserConfigurationException e) {
      e.printStackTrace();
    }
    return nodeList;
  }

  T getResult(NodeList list);

}
