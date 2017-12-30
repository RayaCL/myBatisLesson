package cn.et.lesson05.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


public class Testxml {
	public static SqlSessionFactory getSessionFactory() throws IOException{
		String resource = "cn/et/lesson05/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory;
	}
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson05/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}

	/**
	 * 一级缓存 同一个session对象针对同以分数数据的数据查询 产生的缓存
	 * 第一次查询时调用数据获取数据后
	 * 通过session设置到一级缓存中
	 * 第二次次查询时 通过session一级缓存判断是否存在 相同主键的数据值 如果存在 直接返回引用否则查询数据库
	 * @throws IOException
	 */
	@Test
	public void queryStudent() throws IOException{
		SqlSession session=getSession();
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Student s=gm.queryStudentByid("1");
		//从缓存中查询的
		Student s1=gm.queryStudentByid("1");
		System.out.println(s==s1);
	}
	/**
	 * 二级缓存 同一个sessionFactory下的不同session  可以共享数据
	 * @throws IOException
	 */
	@Test
	public void secondqueryStudent() throws IOException{
		SqlSessionFactory sessionFactory=getSessionFactory();
		SqlSession session=sessionFactory.openSession();
		SqlSession session1=sessionFactory.openSession();
		
		
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Student s=gm.queryStudentByid("1");
		session.close();
		StudentMapper gm1=session1.getMapper(StudentMapper.class);
		Student s1=gm1.queryStudentByid("1");
		System.out.println(s==s1);
	}
}
