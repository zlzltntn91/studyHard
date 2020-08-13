package javaTest.file;

import com.google.common.io.ByteStreams;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.*;

import static org.junit.Assert.assertNotNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FileTest {

  byte[] setFile;

  @Before
  public void setByteArray () {
    File f = new File("D:/file/test.txt");
    try (FileInputStream is = new FileInputStream(f)) {
      setFile = ByteStreams.toByteArray(is);
    } catch (IOException e) {
      e.printStackTrace();
    }
    assertNotNull(setFile);
  }

  @Test
  public void test1 () {

    File f = new File("D:/file/test.txt");

    byte[] file = null;
    try (FileInputStream is = new FileInputStream(f)) {
      file = ByteStreams.toByteArray(is);
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertNotNull(file);

    System.out.println("byte[] length by Guava: " + file.length);
    System.out.println("Content : " + new String(file));
  }

  @Test
  public void test2 () {

    File f = new File("D:/file/test.txt");
    byte[] file = new byte[(int) f.length()];

    try (
      FileInputStream fis = new FileInputStream(f);
      DataInputStream dis = new DataInputStream(fis)
    ) {
      dis.readFully(file);
    } catch (IOException e) {
      e.printStackTrace();
    }

    assertNotNull(file);

    System.out.println("byte[] length by Vanilla Java: " + file.length);
    System.out.println("Content : " + new String(file));
  }

  @Test
  public void test3 () {

    byte[] fileByteArray = setFile;
    String fileName = "바이트에서파일로.txt";

    File saveFilePath = new File("D:/file/temp");
    if(saveFilePath.exists() == false){
      saveFilePath.mkdirs();
    }

    File file = new File(saveFilePath.getAbsolutePath() + "/" + fileName);

    try (
      FileOutputStream fos = new FileOutputStream(file);
      BufferedOutputStream bos = new BufferedOutputStream(fos)
    ) {

      bos.write(fileByteArray);
      bos.flush();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
