package cn.et.lesson05.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
	
	public Student queryStudentByid(String id);
	
}
