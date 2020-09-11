package java.test.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@Slf4j
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {
//  "file:src/main/resources/egovframework/spring/*.xml",
//  "file:src/main/resources/egovframework/spring/context-mapper.xml",
//  "file:src/main/resources/egovframework/spring/context-common.xml"
//})
public class PoiTest {

  final String WORKSPACE = "D://excelTest";


  @Test
  public void XlsBasicTest() {
    // 97 ~ 2003 version
    HSSFWorkbook hwb = new HSSFWorkbook();
    HSSFSheet hs = hwb.createSheet("시트1");
    File xls = new File(WORKSPACE, "XLS테스트.xls");

    boolean mkdirs = xls.getParentFile().exists() == false ? xls.getParentFile().mkdirs() : false;
    log.info("mkdirs :{}", mkdirs);
    try {
      hwb.write(xls);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void XlsxBasicTest() {
    // version 2007 or later
    XSSFWorkbook xsf = new XSSFWorkbook();
    xsf.createSheet("시트1");
    File xls = new File(WORKSPACE, "XLSX테스트.xlsx");

    boolean mkdirs = xls.getParentFile().exists() == false ? xls.getParentFile().mkdirs() : false;
    log.info("mkdirs :{}", mkdirs);

    try {
      FileOutputStream fos = new FileOutputStream(xls);
      xsf.write(fos);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void XlsxTest() {
    // version 2007 or later
    XSSFWorkbook xsf = new XSSFWorkbook();
    XSSFSheet xs = xsf.createSheet("시트1");
    File xls = new File(WORKSPACE, "셀테스트.xlsx");

    boolean mkdirs = xls.getParentFile().exists() == false ? xls.getParentFile().mkdirs() : false;
    log.info("mkdirs :{}", mkdirs);

    XSSFRow xr = xs.createRow(0);

    XSSFCell xs1 = xr.createCell(0);
    xs1.setCellValue("셀 해더 1");
    XSSFCell xs2 = xr.createCell(1);
    xs2.setCellValue("셀 헤더 2");

    try (FileOutputStream fos = new FileOutputStream(xls)) {
      xsf.write(fos);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void excelToDataBase() {
//    String docType = "1";
//    List<OdtVo> list = service.search(docType, "", "", "", "");
//
//    JSONParser jp = new JSONParser();
//    ArrayList<Map<String, String>> jsonList = new ArrayList<>();
//    // tagName이 담겨있는 곳
//    Set<String> keySet = new HashSet<>();
//    //DB 파싱
//    try {
//      // ODT_TEST 테이블의JSON 컬럼을 파싱
//      for (OdtVo vo : list) {
//        jsonList = (ArrayList<Map<String, String>>) jp.parse(vo.getJson());
//      }
//      // tagName
//      for (Map<String, String> map : jsonList) {
//        keySet.add(map.get("tagName"));
//      }
//      log.info("keySet: {}", keySet.toString());
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
  }

  @Test
  public void xlsxTest() {
//    // book
//    XSSFWorkbook xwb = new XSSFWorkbook();
//    // sheet
//    XSSFSheet[] sheets = createSheets(xwb, "하이", "호이");
//    // select
//    String docType = "1";
//    List<OdtVo> list = service.search(docType, "", "", "", "");
//    // rows
//    XSSFRow[] body = createRows(sheets[0], list.size() + 1);
//    // DB Parsing
//    JSONParser jsonParser = new JSONParser();
//    JSONArray jsonArray = new JSONArray();
//    List<List<Map<String, String>>> wrapList = new ArrayList<>();
//    Set<String> keySet = new LinkedHashSet<>();
//    try {
//      for (OdtVo vo : list) {
//        jsonArray = (JSONArray) jsonParser.parse(vo.getJson());
//        wrapList.add(jsonArray);
//      }
//    } catch (ParseException e) {
//      e.printStackTrace();
//    }
//    log.info(wrapList.toString());
//
//    // headerFont
//    CellStyle headStyle = xwb.createCellStyle();
//    XSSFFont headFont = xwb.createFont();
//    headFont.setFontName("맑은 고딕");
//    headFont.setBold(true);
//    headFont.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
//    headFont.setFontHeightInPoints((short) 18);
//    // headerStyle
//    headStyle.setFont(headFont);
//    headStyle.setBorderTop(BorderStyle.DOUBLE);
//    headStyle.setBorderBottom(BorderStyle.DOUBLE);
//    headStyle.setBorderLeft(BorderStyle.DOUBLE);
//    headStyle.setBorderRight(BorderStyle.DOUBLE);
//    headStyle.setFillBackgroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
//    headStyle.setFillPattern(FillPatternType.NO_FILL);
//    headStyle.setAlignment(HorizontalAlignment.CENTER);
//    headStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//    // bodyStyle
//    CellStyle bodyStyle = xwb.createCellStyle();
//    bodyStyle.setBorderTop(BorderStyle.THIN);
//    bodyStyle.setBorderBottom(BorderStyle.THIN);
//    bodyStyle.setBorderLeft(BorderStyle.THIN);
//    bodyStyle.setBorderRight(BorderStyle.THIN);
//    bodyStyle.setVerticalAlignment(VerticalAlignment.CENTER);
//    // tableHeader
//    keySet.add("date");
//    keySet.add("docType");
//    keySet.add("fileName");
//
//    for (int i = 0; i < wrapList.get(0).size(); i++) {
//      keySet.add(wrapList.get(0).get(i).get("tagName"));
//    }
//
//    for (int i = 0; i < body.length; i++) {
//      List<String> valueList = new ArrayList<>();
//      // 첫 줄에 컬럼명
//      if (i == 0) {
//        for (int j = 0; j < wrapList.get(i).size(); j++) {
//          valueList = new ArrayList<>(keySet);
//        }
//        createCells(sheets[0], body[i], valueList, headStyle);
//        // 두번째 줄 부터 데이터
//      } else {
//        valueList.add(list.get(i - 1).getDate());
//        valueList.add(list.get(i - 1).getDocType());
//        valueList.add(list.get(i - 1).getFileName());
//        for (int j = 0; j < wrapList.get(i - 1).size(); j++) {
//          valueList.add(wrapList.get(i - 1).get(j).get("tagValue"));
//        }
//        createCells(sheets[0], body[i], valueList, bodyStyle);
//      }
//      log.info("valueList :{}", valueList.toString());
//    }
//    // createFile
//    boolean makeXlsx = createExcelFile(xwb, WORKSPACE, "테스트");
//    log.info("makeXlsx :{}", makeXlsx);
  }

  public boolean createExcelFile(XSSFWorkbook xwb, String path, String fileName) {
    String XLSX_EXTENSION = ".xlsx";
    File xlsx = new File(path, fileName + XLSX_EXTENSION);
    try (FileOutputStream fos = new FileOutputStream(xlsx)) {
      xwb.write(fos);
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public XSSFSheet[] createSheets(XSSFWorkbook xwb, String... names) {
    XSSFSheet[] sheetArray = new XSSFSheet[names.length];
    for (int i = 0; i < names.length; i++) {
      sheetArray[i] = xwb.createSheet(names[i]);
    }
    log.info("Sheet size : {}", sheetArray.length);
    return sheetArray;
  }

  public XSSFRow[] createRows(XSSFSheet xs, int count) {
    XSSFRow[] rows = new XSSFRow[count];
    for (int i = 0; i < count; i++) {
      rows[i] = xs.createRow(i);
    }
    return rows;
  }

  public XSSFCell[] createCells(XSSFSheet xs, XSSFRow row, List<String> value, CellStyle style) {
    XSSFCell[] cells = new XSSFCell[value.size()];
    for (int i = 0; i < value.size(); i++) {
      xs.autoSizeColumn(i);
      cells[i] = row.createCell(i);
      cells[i].setCellValue(value.get(i));
      cells[i].setCellStyle(style);
    }
    return cells;
  }
//
//  public void setFont(XSSFFont font, short color, short height, String fontName, boolean italic) {
//    font.setColor(color);
//    font.setFontHeightInPoints(height);
//    font.setItalic(italic);
//    font.setFontName(fontName);
//  }
}
