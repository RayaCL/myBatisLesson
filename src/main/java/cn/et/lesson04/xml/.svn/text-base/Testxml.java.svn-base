package cn.et.lesson04.xml;

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
		String resource = "cn/et/lesson04/xml/mybatis.xml";
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
		s.setSname("王");
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
		Integer sex=null;
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
		s.setSname("寡人");
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
	public void insertStudent() throws IOException{
		SqlSession session=getSession();
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Student student =new Student();
		student.setSid(7);
		student.setSname("齐傻");
		student.setSex(1);
		student.setAge(23);
		student.setAddress("甘肃");
		gm.insertStudent(student);
		session.commit();
	
	}
}
