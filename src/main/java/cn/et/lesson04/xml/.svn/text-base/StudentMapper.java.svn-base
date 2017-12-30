package cn.et.lesson04.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;


public interface StudentMapper {
	
	public List<Student> queryStudent(Student student);
	/**
	 * 通过性别来查
	 */
	public List<Student> queryBySex(@Param("sex")Integer sex);
	/**
	 * 修改
	 */
	public void updateStudent(Student student);
	/**
	 * 通过班级查询学生
	 */
	public List<Student> queryStudentByGradeId(@Param("gradeList")List<String> gradeList);
	/**
	 * 添加学生
	 */
	public void insertStudent(Student student);
	/**
	 * 删除学生
	 */
	public void deleteStudent(String student);
}
