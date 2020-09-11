package java.test;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "file:src/main/resources/egovframework/spring/context-datasource.xml" })
public class DataSourceTest {

  @Resource(name = "dataSource")
  DataSource datasource;

  @Test
  public void dataSourceTest() throws SQLException {
    assertNotNull(datasource);
    Connection c = datasource.getConnection();

    String query = "select count(*) as count from ODT_TEST";
    PreparedStatement pstmt = c.prepareStatement(query);
    assertTrue(pstmt.execute());

    ResultSet rs = pstmt.getResultSet();
    System.out.println("─────────────────────────────");
    System.out.println("dataSource : " + datasource.toString());
    System.out.println("connection : " + c.toString());
    while (rs.next()) {
      System.out.println(query + " : " + rs.getString("count"));
    }
    System.out.println("─────────────────────────────");
  }

}
