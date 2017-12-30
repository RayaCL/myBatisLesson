package cn.et.lesson02.xml;

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
		String resource = "cn/et/lesson02/xml/mybatis.xml";
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
		fm.queryFoodByFoodName("���ӳ���");
		session.commit();
	}
	@Test
	public void testsaveFood() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		Food food=new Food();
		food.setFoodname("dfdfd");
		food.setPrice("45");
		fm.saveFood(food);
		session.commit();
		System.out.println(food.getFoodId());
	}
	@Test
	public void testdelete() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		fm.deleteFood("1");
		session.commit();
	}
}
