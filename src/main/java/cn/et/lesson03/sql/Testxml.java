package cn.et.lesson03.sql;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.et.lesson02.Food;

public class Testxml {
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson03/sql/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}
	@Test
	public void testsave() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		fm.queryFood("���ӳ���","98");
		session.commit();
	}
	
}
