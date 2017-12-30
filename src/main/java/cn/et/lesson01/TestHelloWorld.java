package cn.et.lesson01;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class TestHelloWorld {
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson01/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}
	public static void main(String[] args) throws IOException {
		SqlSession session=getSession();
		//session操作的是 只向sql语句的一个唯一表示服
		List list=session.selectList("a.selectFood");
		System.out.println(list);
		Map map=(Map) session.selectOne("a.selectFoodById");
		System.out.println(map);
		Map map1=new HashMap();
		map1.put("foodid", "3");
		map1.put("foodname", "dfdf");
		map1.put("price", "12");
		
//		session.insert("a.insertFood",map1);
		Food food=new Food();
		food.setFoodid(1);
		food.setFoodname("鸡丁");
		food.setPrice("98");
//		session.update("a.updateFood",food);
//		session.delete("a.deleteFood","3");
		session.commit();
	}
	/**
	 * 自定义log
	 */
	Logger logger=Logger.getLogger(TestHelloWorld.class);
	@Test
	public void testQueryByParam() throws IOException{
		SqlSession session=getSession();
//		Map map1=new HashMap();
//		map1.put("foodid", "3");
//		map1.put("foodname", "鸡丁");
//		map1.put("price", "68");
		
		Food food=new Food();
		food.setFoodid(1);
		food.setFoodname("鸡丁");
		food.setPrice("98");
		List list= session.selectList("a.selectFoodParam",food);
//		System.out.println(list);
		logger.debug(list);
	}
	@Test
	public void testsave() throws IOException{
		SqlSession session=getSession();
		Map map1=new HashMap();
		map1.put("foodname", "卤蛋");
		map1.put("price", "68");
		 session.insert("a.saveFood",map1);
		session.commit();
	}
}
