package cn.et.lesson02.annotion;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.et.lesson02.Food;


public class Testxml {
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson02/annotion/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}
	@Test
	public void testsave() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		fm.queryFood("辣子炒蛋", "56");
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
	public void testsavebyFoodname() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		fm.queryFoodByFood("辣子炒蛋");
		session.commit();
	}
	@Test
	public void testdelete() throws IOException{
		SqlSession session=getSession();
		FoodMapper fm=session.getMapper(FoodMapper.class);
		fm.deleteFood("1");
		session.commit();
	}
}
