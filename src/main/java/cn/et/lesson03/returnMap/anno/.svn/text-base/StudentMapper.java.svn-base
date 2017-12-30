package cn.et.lesson03.returnMap.anno;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.et.lesson03.returnMap.xml.Student;


public interface StudentMapper {
	
	/**
	 * 通过编号查询学生
	 */
	@Results({
		@Result(property="grade",column="gid",one=@One(select="cn.et.lesson03.returnMap.anno.GradeMapper.queryGradeByGid"))
		})
	@Select("select * from student where sid=#{0}")
	public Student queryStudent(String sid);
	/**
	 * 通过班级ID查询学生
	 */
	@Select("select * from student where gid=#{0}")
	public List<Student> queryStudentByGid(String gid);
	
}
