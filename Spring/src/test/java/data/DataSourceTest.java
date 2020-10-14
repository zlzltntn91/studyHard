package data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/egovframework/spring/context-datasource.xml" })
public class DataSourceTest {

  @Resource(name = "dataSource")
  DataSource datasource;

  @Test
  public void dataSourceTest() throws SQLException {
    Assert.assertNotNull(datasource);
    Connection c = datasource.getConnection();
    String query = "select 1+1";
    PreparedStatement pstmt = c.prepareStatement(query);
    Assert.assertTrue(pstmt.execute());
    ResultSet rs = pstmt.getResultSet();
    System.out.println("─────────────────────────────");
    System.out.println("dataSource : " + datasource.toString());
    System.out.println("connection : " + c.toString());
    System.out.println("─────────────────────────────");
  }
}
