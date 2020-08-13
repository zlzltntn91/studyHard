package thirdParyTest;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GetFileHashTest {
  @Test
  public void getFileHash() {
    // 720de36bb3e40a4c67bdf0137b12ae0fd733aef772d81a4b8dab00f29924ddd17ecb2a7217b9551fc0ca51bd81d1da13ad63b6694c445e5c0e42dfa7f279ede1 *apache-tomcat-8.5.57.tar.gz
    File f = new File("C:\\Users\\dgtazm9513\\Downloads\\apache-tomcat-8.5.57.tar.gz");
    StringBuilder result = new StringBuilder();
    try (FileInputStream fis = new FileInputStream(f);) {
      MessageDigest md = MessageDigest.getInstance("SHA-512");
      byte[] buffer = new byte[1024];
      int numRead;
      do {
        numRead = fis.read(buffer);
        if (numRead > 0) {
          md.update(buffer, 0, numRead);
        }
      } while (numRead != -1);
      byte[] b = md.digest();
      for (byte value : b) {
        result.append(Integer.toString((value & 0xff) + 0x100, 16).substring(1));
      }
      System.out.println(result);
    } catch (IOException | NoSuchAlgorithmException e) {
      e.printStackTrace();
    }
  }

}
