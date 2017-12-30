package cn.et.lesson04.anno;

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
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson04/anno/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}


	@Test
	public void queryStudent() throws IOException{
		SqlSession session=getSession();
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Student s=new Student();
//		s.setSname("王");
		s.setAddress("甘肃");
		 List<Student> st=gm.queryStudent(s);
		for(Student t:st){
			System.out.println(t.getSname());
		}
	}
	@Test
	public void queryBySex() throws IOException{
		SqlSession session=getSession();
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Integer sex=0;
		 List<Student> st=gm.queryBySex(sex);
		for(Student t:st){
			System.out.println(t.getSname());
		}
	}
	@Test
	public void updateStudent() throws IOException{
		SqlSession session=getSession();
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Student s=new Student();
		s.setSid(1); 
		s.setSname("傻子");
		gm.updateStudent(s);
		session.commit();
	
	}
	@Test
	public void queryStudentbygid() throws IOException{
		SqlSession session=getSession();
		StudentMapper gm=session.getMapper(StudentMapper.class);
		List list=new ArrayList();
		list.add("3");
		list.add("4");
		List<Student> l=gm.queryStudentByGradeId(list);
		for(Student t:l){
			System.out.println(t.getSname());
		}
		session.commit();
	}
	@Test
	public void insterStudent() throws IOException{
		SqlSession session=getSession();
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Student s=new Student();
		s.setSid(8); 
		s.setSname("傻宝");
		s.setSex(1);
		s.setAge(20);
		s.setAddress("兰州");
		gm.insertStudent(s);
		session.commit();
	
	}
}
