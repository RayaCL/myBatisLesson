package cn.et.lesson03.returnMap.anno;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.et.lesson03.returnMap.xml.Grade;


public interface GradeMapper {
	/**
	 * 根据名称查询所有的班级
	 * @param foodName
	 * @return
	 */
	public List<Grade> queryAllGrade();
	/**
	 * 通过gid查询班级
	 * @param gid
	 * @return
	 */
	@Results({@Result(property="gname1",column="gname"),
				@Result(property="studentList",column="gid",javaType=ArrayList.class,many=@Many(select="cn.et.lesson03.returnMap.anno.StudentMapper.queryStudentByGid"))
	})
	@Select("select * from grade where gid=#{0}")
	public Grade queryGrade(String gid);
	
	@Results(@Result(property="gname1",column="gname"))
	@Select("select * from grade where gid=#{0}")
	public Grade queryGradeByGid(String gid);
}
