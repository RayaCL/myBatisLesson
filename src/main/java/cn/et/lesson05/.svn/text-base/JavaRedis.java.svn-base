package cn.et.lesson05;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import redis.clients.jedis.Jedis;

public class JavaRedis {
	/**
	 * 1=Student对象
	 * 写入数到redis时
	 * jedis.set(主键,objectToByreArray(Student对象))
	 * 序列化
	 * @param obj
	 * @return
	 */
	public static  byte[] objectToByteArray(Object obj){
		ByteOutputStream bos=new ByteOutputStream();
		try {
			ObjectOutputStream  oos=new ObjectOutputStream(bos);
			oos.writeObject(obj);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bos.getBytes();
	}
	/**
	 * byte[] bt=get("主键")
	 * 反序列化字节数组为 对象
	 * 
	 * @param bt
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object byteArrayToObject(byte[] bt) throws IOException, ClassNotFoundException{
		ByteInputStream bis=new ByteInputStream(bt,bt.length);
		ObjectInputStream ois=new ObjectInputStream(bis);
		return  ois.readObject();
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Jedis jedis=new Jedis("localhost",6379);
		//键值对
		jedis.set("myname", "jiaozi");
		System.out.println(jedis.get("myname"));
	}
}
