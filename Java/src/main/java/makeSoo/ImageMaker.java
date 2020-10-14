package makeSoo;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
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
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

@Slf4j
public class ImageMaker {

  public static void main (String[] args) {
    ImageMaker mm = new ImageMaker();
    LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
    mm.make(ldt, "18", "한글테스트하", "222222", true);
    mm.make(ldt, "18", "한글테스트하", "222222", false);
    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font[] fonts = e.getAllFonts();
    for (Font font : fonts) {
      System.out.println(font.getFontName());
    }
  }

  public String make (LocalDateTime ldt, String docType, String previewText, String minno, boolean pass){
    previewText = new String(previewText.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);

    log.info("마크메이커 : {}", previewText);

    BufferedImage image = null;
    String backgroundImgDir = "";
    log.info(backgroundImgDir);
    int imgWidth = 0;

    try {
      // FIXME 증명서명 분기
      try {
        if (pass) {
          if (Integer.parseInt(docType) == 18) {
            image = ImageIO.read(new File(backgroundImgDir, "/졸업증명서.png"));
          } else if (Integer.parseInt(docType) == 8) {
            image = ImageIO.read(new File(backgroundImgDir + "/성적증명서.png"));
          } else {
            image = ImageIO.read(new File(backgroundImgDir + "/업로드문서.png"));
          }
        } else {
          if (Integer.parseInt(docType) == 18) {
            image = ImageIO.read(new File(backgroundImgDir, "/졸업증명서_PASS.png"));
          } else if (Integer.parseInt(docType) == 8) {
            image = ImageIO.read(new File(backgroundImgDir + "/성적증명서_PASS.png"));
          } else {
            image = ImageIO.read(new File(backgroundImgDir + "/업로드문서_PASS.png"));
          }
        }
      } catch (NumberFormatException e) {
        if (pass) {
          if (docType.equals("U")) {
            image = ImageIO.read(new File(backgroundImgDir + "/업로드문서.png"));
          }
        } else {
          image = ImageIO.read(new File(backgroundImgDir + "/업로드문서_PASS.png"));
        }
      }
      imgWidth = image.getWidth();
    } catch (Exception e) {
      e.printStackTrace();
    }

    DateTimeFormatter ymd = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    DateTimeFormatter hms = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter btsa = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    log.debug("#### TimeZone : {}", ldt);
    String strYMD = ymd.format(ldt);
    String strHMS = hms.format(ldt);
    String serilaCode = makeSerialCode(btsa.format(ldt), minno);
    assert image != null;
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
    int[] lineHeight = {215, 255, 295};
    // 33 / 9.0
    int getLine = (int) Math.ceil(previewText.length() / (float) maxCharCount);
    if (getLine != 1) {
      // 2줄 이상
      g.setFont(new Font("NanumGothic", Font.PLAIN, 32));
      metrics = g.getFontMetrics();

      for (int i = 0; i <= 1; i++) { // 두줄만하자..
        giwanNeList.add(new String(previewText.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8).substring(tempCount, maxCharCount));
        tempCount = maxCharCount; // 9
        maxCharCount = i == 0 ? maxCharCount * 2 : previewText.length(); // 18
        // //giwanNe.length();
        if (i == 1) {
          giwanNeWidth = metrics.stringWidth(giwanNeList.get(i) + "...");
          g.drawString(giwanNeList.get(i) + "...", (imgWidth - giwanNeWidth) / 2, lineHeight[i]); // 학교명
        } else {
          giwanNeWidth = metrics.stringWidth(giwanNeList.get(i));
          g.drawString(giwanNeList.get(i), (imgWidth - giwanNeWidth) / 2, lineHeight[i]); // 학교명
        }
      }
    } else {
      // 1줄
      g.setFont(new Font("NanumGothic", Font.PLAIN, 40));
      metrics = g.getFontMetrics();
      giwanNeWidth = metrics.stringWidth(new String(previewText.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8));
      g.drawString(previewText, (imgWidth - giwanNeWidth) / 2, 240); // 학교명
    }

    // 삽입 폰트 기본 세팅
    g.setFont(new Font("NanumGothic", Font.PLAIN, 37));
    metrics = g.getFontMetrics();
    // FIXME uniqueCode
    // X 는 (이미지사이즈 - 문자열넓이) / 2
    // Y 는 이미지 사이즈가 600x600으로 가정하여 FIXME 하드코딩
    int serialCodeWidth = metrics.stringWidth(serilaCode);
    g.drawString(serilaCode, (imgWidth - serialCodeWidth) / 2, 315); // 유니크코드
    int ymdWidth = metrics.stringWidth(strYMD);
    g.drawString(strYMD, (imgWidth - ymdWidth) / 2, 375); // 년월일
    int hmsWidth = metrics.stringWidth(strHMS);
    g.drawString(strHMS, (imgWidth - hmsWidth) / 2, 415); // 시분초
    int kstWidth = metrics.stringWidth("KST");
    g.drawString("KST", (imgWidth - kstWidth) / 2, 455); // KST

    String markPath = "";
    File markDir = new File(markPath);
    File markFile;
    if (pass) {
      markFile = new File(markDir.getPath(), minno + ".png");
    } else {
      markFile = new File(markDir.getPath(), minno + "_PASS" + ".png");
    }
    try {
      if (markDir.exists() == false) markDir.mkdirs();
      ImageIO.write(image, "png", markFile);
      g.dispose();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "" + "/" + markFile.getName();
  }

  public String makeSerialCode (String timeStamp, String minno) {
    String BTSA = timeStamp.substring(2, timeStamp.length() - 4);
    String MINNO = minno.substring(minno.length() - 4).toUpperCase();
    String serialCode = BTSA + MINNO;

    // 문자열 반대로 출력하는 소스
    ArrayList<String> serialCodeList = new ArrayList<>();

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
    for (int i = 0; i <= serialCodeList.size() - 1; i++) {
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
    return str;
  }
}
