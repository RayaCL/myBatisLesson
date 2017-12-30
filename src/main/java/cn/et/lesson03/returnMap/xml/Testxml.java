package cn.et.lesson03.returnMap.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


public class Testxml {
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson03/returnMap/xml/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}
	@Test
	public void testsave() throws IOException{
		SqlSession session=getSession();
		GradeMapper gm=session.getMapper(GradeMapper.class);
		List<Grade> list=gm.queryAllGrade();
		for(Grade l:list){
			System.out.println(l.getGid()+"========"+l.getGname1());
		}
		System.out.println(list.size());
	}
	/**
	 * mybatis懒加载
	 * 关联的对象是访问其属性是才加载
	 * @throws IOException
	 */
	@Test
	public void queryStudent() throws IOException{
		SqlSession session=getSession();
		StudentMapper gm=session.getMapper(StudentMapper.class);
		 Student s=gm.queryStudent("1");
		 System.out.println(s.getGrade().getGname1());
//		System.out.println(s.getSname()+"="+s.getGrade().getGname1());
	}
	@Test
	public void oneToMany() throws IOException{
		SqlSession session=getSession();
		GradeMapper gm=session.getMapper(GradeMapper.class);
		Grade g=gm.queryGrade("3");
		for(Student s:g.getStudentList()){
			System.out.println(s.getSname());
		}
		System.out.println(g.getStudentList().size());
	}
}
