package cn.et.lesson02.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.et.lesson02.Food;

public interface FoodMapper {
	/**
	 * 根据名称查询所有的菜品信息
	 * @param foodName
	 * @return
	 */
	public List queryFood(String foodName,String price);
	
	public List queryFoodByFoodName(@Param("foodName") String foodName);
	/**
	 * 根据id删除
	 * @param foodId
	 */
	public void deleteFood(String foodId);
	/**
	 * 插入food
	 */
	public void saveFood(Food food);
	
}
