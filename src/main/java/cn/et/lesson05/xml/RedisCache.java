package cn.et.lesson05.xml;

import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;

import cn.et.lesson05.JavaRedis;
import redis.clients.jedis.Jedis;

public class RedisCache implements Cache {
	
	
	/**
	 * ����redis����
	 */
	Jedis jedis=new Jedis("localhost",6379);
	/*
	 * �����ID
	 */
	private String cacheId;
	public RedisCache(String cacheId){
		this.cacheId=cacheId;
	}
	public void clear() {
//		jedis.flushDB();

	}

	public String getId() {
		// TODO Auto-generated method stub
		return cacheId;
	}
	/**
	 * mybatis�Զ�����getObject����Ƿ񻺴��д���
	 */
	public Object getObject(Object key) {
		byte[] bt=jedis.get(JavaRedis.objectToByteArray(key));
		try {
			if(bt==null){
				return null;
			}
			return JavaRedis.byteArrayToObject(bt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return new ReentrantReadWriteLock();
	}


	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}
	/*
	 * mybatis��ȡ����ʱ�����ݿ��ж�ȡ������ ͨ��putObject���õ�������
	 * 	 */

	public void putObject(Object key, Object value) {
		//д��redis
		jedis.set(JavaRedis.objectToByteArray(key), JavaRedis.objectToByteArray(value));

	}
	/**
	 * mybatis ������� �Զ��ж��ڴ�ĵĴ�С  �����Ƿ�ɾ��ĳЩ���ھ�Զ����
	 */

	public Object removeObject(Object key) {
		Object obj=getObject(key);
		jedis.del(JavaRedis.objectToByteArray(key));
		return obj;
	}

}
