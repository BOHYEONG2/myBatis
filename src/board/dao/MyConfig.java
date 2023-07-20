package board.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyConfig {

	private SqlSession session;
	//session�� �̿��ؼ� select update delete ���� �����ϰ� ���ش� 
	// �Ѱ���� �ϴ¾� �־�� �ϴ� getInstanse �޼ҵ� �ϳ� ������ش�
	public MyConfig() {
		String resource = "mybatis-config.xml";
		try {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public SqlSession getInstance() {
		return session;
	}

	
}
