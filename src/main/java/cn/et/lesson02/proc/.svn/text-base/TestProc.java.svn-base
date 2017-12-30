package cn.et.lesson02.proc;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class TestProc {
	public static SqlSession getSession() throws IOException{
		String resource = "cn/et/lesson02/proc/mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//π§≥ß¿‡
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		return session;
	}
	@Test
	public void testproc() throws IOException{
		SqlSession session=getSession();
		Map map=new HashMap();
		map.put("p1", 1111);
		map.put("p2", 1212);
		String r=session.selectOne("call_prg_add",map);
		System.out.println(map.get("result"));
	}
	@Test
	public void testfun() throws IOException{
		SqlSession session=getSession();
		Map map=new HashMap();
		map.put("p1", 1111);
		map.put("p2", 1212);
		String r=session.selectOne("call_fun_add",map);
		System.out.println(map.get("result"));
	}
	
}
