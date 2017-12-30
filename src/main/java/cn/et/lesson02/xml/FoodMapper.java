package cn.et.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.et.lesson02.Food;

public interface FoodMapper {
	/**
	 * �������Ʋ�ѯ���еĲ�Ʒ��Ϣ
	 * @param foodName
	 * @return
	 */
	public List queryFood(String foodName,String price);
	
	public List queryFoodByFoodName(@Param("foodName") String foodName);
	/**
	 * ����idɾ��
	 * @param foodId
	 */
	public void deleteFood(String foodId);
	/**
	 * ����food
	 */
	public void saveFood(Food food);
	
}
