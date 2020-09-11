package makeSoo;

import com.google.gson.JsonObject;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.NodeList;

import javax.imageio.ImageIO;
import javax.imageio.metadata.IIOInvalidTreeException;
import javax.imageio.metadata.IIOMetadata;
import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.imageio.metadata.IIOMetadataNode;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ImageMaker {

  @Test
  @Ignore
  public void getPath() {
    File f = new File(".");
    System.out.println(f.getAbsolutePath());
    String imgDir = "C:/Users/dgtazm9513/local-git/studyHard/Java/images/";
    File f2 = new File(imgDir + "졸업증명서.png");
    System.out.println(f2.getAbsolutePath());
    System.out.println(f2.exists());
  }

  @Test
  @Ignore
  public void metaInsertAndSelect() {
    String imgDir = "C:/Users/dgtazm9513/local-git/studyHard/Java/images/";
    File f2 = new File(imgDir + "졸업증명서.png");
  }

  /**
   * PNG 파일에 메타데이터 삽입
   *
   * @param metadata
   * @param key
   * @param value
   * @throws IIOInvalidTreeException
   */
  public void addTextEntry(IIOMetadata metadata, String key, String value) throws IIOInvalidTreeException {
    IIOMetadataNode textEntry = new IIOMetadataNode("TextEntry");
    textEntry.setAttribute("keyword", key);
    textEntry.setAttribute("value", value);

    IIOMetadataNode text = new IIOMetadataNode("Text");
    text.appendChild(textEntry);

    IIOMetadataNode root = new IIOMetadataNode(IIOMetadataFormatImpl.standardMetadataFormatName);
    root.appendChild(text);

    metadata.mergeTree(IIOMetadataFormatImpl.standardMetadataFormatName, root);
  }

  /**
   * PNG 파일에 메타데이터 조회
   *
   * @param metadata
   * @param key
   * @return
   */
  public String getTextEntry(IIOMetadata metadata, String key) {
    IIOMetadataNode root = (IIOMetadataNode) metadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName);
    NodeList entries = root.getElementsByTagName("TextEntry");

    for (int i = 0; i < entries.getLength(); i++) {
      IIOMetadataNode node = (IIOMetadataNode) entries.item(i);
      if (node.getAttribute("keyword").equals(key)) {
        return node.getAttribute("value");
      }
    }

    return null;
  }

  @Test
  public void getTime() throws ParseException {
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String t = sdf.format(d);
    System.out.println(t);
  }

  @Test
  public void T() {

    JsonObject jObject = new JsonObject();
    JsonObject jObj2 = new JsonObject();

    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    // 증명서 마크 생성
    String giwanNe = "일이삼사오육칠팔구십일이삼사오육칠팔구십";
    String minno = "M987654321";
    String docType = "졸업증명서";
    String timeStamp = sdf.format(d);

    System.out.println("timeStamp : " + timeStamp);

    String BTSA = timeStamp.substring(2, timeStamp.length() - 4);
    String MINNO = minno.substring(minno.length() - 4, minno.length()).toUpperCase();
    String serialCode = BTSA + MINNO;

    System.out.println("serialCode : " + serialCode);

    // 문자열 반대로 출력하는 소스
    ArrayList<String> serialCodeList = new ArrayList<>(); // ["0191", "1071", "RBSF"]

    int digits = 4; // 문자열 커팅에 사용되는 변수 (자릿수)
    String temp = ""; // digits 수만큼 문자열 저장
    String temp2 = ""; // temp에 저장한 문자열을 반대로 뽑아내어 저장하는

    // 변수
    for (int i = 1; i <= serialCode.length(); i++) {
      temp += serialCode.charAt(i - 1);
      if (i % digits == 0) {
        for (int j = digits - 1; j >= 0; j--) {
          temp2 += temp.charAt(j);
        }
        serialCodeList.add(temp2);
        temp = "";
        temp2 = "";
      }
    }

    // 16진수 변환 소스
    int hex = 0;
    String str = "";
    String strSerialCode = "";
    for (
      int i = 0;
      i <= serialCodeList.size() - 1; i++) {
      strSerialCode = "";
      try {
        hex = Integer.parseInt(serialCodeList.get(i));
        strSerialCode = Integer.toHexString(hex);
        switch (strSerialCode.length()) {
          case 2:
            strSerialCode = "0D" + strSerialCode;
            break;
          case 3:
            strSerialCode = "0" + strSerialCode;
            break;
        }
        str += strSerialCode + " ";
      } catch (NumberFormatException e) {
        str += serialCodeList.get(i);
      }
    }

    str = str.toUpperCase();

    // 증명서 종류별 이미지 객체 생성
    BufferedImage image = null;
//    String classPath = "";
//    String projectPath = classPath.substring(0, classPath.lastIndexOf("WEB-INF"));

    String imgDir = "C:/Users/dgtazm9513/local-git/studyHard/Java/images/";
    String dir = imgDir;
    // image = ImageIO.read(new
    // File(dir+"졸업_한(600).png"));
    int imgWidth = 0;
    int imgHeight = 0;

    try {
      if (docType.contains("졸업증명서")) {
        image = ImageIO.read(new File(dir + "졸업증명서.png"));
      } else if (docType.contains("성적증명서")) {
        image = ImageIO.read(new File(dir + "성적증명서.png"));
      } else if (docType.contains("교육비납입증명서")) {
        image = ImageIO.read(new File(dir + "교육비납입증명서.png"));
      } else if (docType.contains("수료증명서")) {
        image = ImageIO.read(new File(dir + "수료증명서.png"));
      } else if (docType.contains("재학증명서")) {
        image = ImageIO.read(new File(dir + "재학증명서.png"));
      }
      if (image != null) {
        imgWidth = image.getWidth();
        imgHeight = image.getHeight();
      }
    } catch (Exception e) {
      e.printStackTrace();
//      jObject.put("resultCode", "6303");
//      jObject.put("resultMsg", "증명서 마크 파일 읽기에 실패했습니다.");
//      System.out.println("");
//      response.getWriter().write(jObject.toJSONString());
//      return;
    }

    // String -> Date
    SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
    Date date = null;
    try {
      date = format.parse(timeStamp);
    } catch (ParseException e) {
      e.printStackTrace();
    }

    // Date -> ymd, hms
    SimpleDateFormat ymd = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat hms = new SimpleDateFormat("HH:mm:ss");
    String strYMD = ymd.format(date);
    String strHMS = hms.format(date);

    Graphics g = image.getGraphics();
    FontMetrics metrics = null;
    ArrayList<String> giwanNeList = new ArrayList<>();
    g.setColor(Color.BLACK);

    /*
     * 한줄에 출력할 수 있는지 없는지 구분 의도한 디자인대로 출력할 수 있는 조건 = 글자수
     * 최대 18자리
     */
    int maxCharCount = 9;
    int tempCount = 0;
    int giwanNeWidth = 0;
    int lineHeight[] = {220, 260, 300};
    int getLine = (int) Math.ceil(giwanNe.length() / (float) maxCharCount);
    if (getLine != 1) {
      // 2줄 이상
      g.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 32));
      metrics = g.getFontMetrics();
      getLine = getLine >= 3 ? 3 : getLine;
      for (int i = 0; i <= getLine - 1; i++) {
        giwanNeList.add(giwanNe.substring(tempCount, maxCharCount));
        tempCount = maxCharCount; // 9
        maxCharCount = i == 0 ? maxCharCount * 2 : giwanNe.length(); // 18
        // //giwanNe.length();
        giwanNeWidth = metrics.stringWidth(giwanNeList.get(i));
        g.drawString(giwanNeList.get(i), (imgWidth - giwanNeWidth) / 2, lineHeight[i]); // 학교명
      }
    } else {
      // 1줄
      g.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 40));
      metrics = g.getFontMetrics();
      giwanNeWidth = metrics.stringWidth(giwanNe);
      g.drawString(giwanNe, (imgWidth - giwanNeWidth) / 2, 240); // 학교명
    }

    // 삽입 폰트 기본 세팅
    g.setFont(new Font("나눔스퀘어 Bold", Font.PLAIN, 37));
    metrics = g.getFontMetrics();

    int serialCodeWidth = metrics.stringWidth(str);
    g.drawString(str, (imgWidth - serialCodeWidth) / 2, 320); // 유니크코드

    int ymdWidth = metrics.stringWidth(strYMD);
    g.drawString(strYMD, (imgWidth - ymdWidth) / 2, 380); // 년월일

    int hmsWidth = metrics.stringWidth(strHMS);
    g.drawString(strHMS, (imgWidth - hmsWidth) / 2, 420); // 시분초

    int kstWidth = metrics.stringWidth("KST");
    g.drawString("KST", (imgWidth - kstWidth) / 2, 460); // KST

    g.dispose();

    File f = new File(dir + "/mark");
    String savePath = "";
    try {
      // 폴더 생성
      if (!f.exists()) {
        f.mkdir();
      }
      savePath = f.getPath();
      // 파일 저장
      // f = new File(savePath +"/" +str.replace(" ",
      // "")+".png");
      f = new File(savePath + "/" + minno + ".png");
      ImageIO.write(image, "png", f);

    } catch (
      Exception e) {
//      jObj2.put("serial", "-1");
//      jObj2.put("resultCode", "6304");
//      jObj2.put("resultMsg", "증명서 마크 생성에 실패했습니다.");
    }

//    jObj2.put("serial", str.replace(" ", ""));
//    jObj2.put("resultCode", "200");
//    jObj2.put("dir", "/wm1.0/images/scoutImages/mark/" + minno + ".png");
//
//    jObject.put("certMark", jObj2);
//    jObject.put("resultCode", "200");
//    jObject.put("resultMsg", "");
//    jObject.put("certAddr","http://scout.doculink.kr/MinwonScout.do?CMD=CERT_PRINT&GBN=SCT&GNO=" + sGiwanNo+ "&CERTNO=" + sMinNo);
//    jObject.put("downAddr","http://scout.doculink.kr/MinwonScout.do?CMD=CERT_DOWN&GBN=SCT&GNO=" + sGiwanNo+ "&CERTNO=" + sMinNo);
//    String jsonInfo = jObject.toJSONString();
//    response.getWriter().write(jsonInfo);
  }
}
