package data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:web/WEB-INF/config/context-datasource.xml",
				                  					"file:web/WEB-INF/config/context-mapper.xml"
})
public class SqlSessionTest {

	@Resource(name = "sqlSession")
	SqlSessionFactory sqlSession;

	@Test
	public void sqlSessionTest() {
		assertNotNull(sqlSession);
		assertNotNull(sqlSession.openSession());
	}
}
