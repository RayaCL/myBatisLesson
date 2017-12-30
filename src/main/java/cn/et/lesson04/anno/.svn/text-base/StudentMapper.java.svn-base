package cn.et.lesson04.anno;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.jdbc.SQL;



public interface StudentMapper {
	static class StudentProvier{
		/**
		 * 提供sql 的方法
		 * ${}在注解的情况下失效
		 * 对象的属性 取值 别名.属性名
		 * 提供sql方法的参数是map 键值对
		 * @param map
		 * @return
		 */
		public String queryStudentSql(Map map){
			Student student =(Student)map.get("stu");
			String sql="select * from student where 1=1 ";
			if(student.getSname()!=null&&!"".equals(student.getSname())){
				student.setSname("%"+student.getSname()+"%");
				sql+="and sname like #{stu.sname} ";
			}
			if(student.getAddress()!=null&&!"".equals(student.getAddress())){
				student.setAddress("%"+student.getAddress()+"%");
				sql+="and address like #{stu.address}";
			}
			return sql;
		}
		public String queryStudentSql1(Map map){
			Student student =(Student)map.get("stu");
			SQL sql=new SQL();
			sql.SELECT("*").FROM("student");
			if(student.getSname()!=null&&!"".equals(student.getSname())){
				student.setSname("%"+student.getSname()+"%");
				sql.WHERE(" sname like #{stu.sname}");
			}
			if(student.getAddress()!=null&&!"".equals(student.getAddress())){
				student.setAddress("%"+student.getAddress()+"%");
				sql.AND();
				sql.WHERE(" address like #{stu.address}");
			}
			return sql.toString();
		}
		public String updateStudentSql(Map map){
			Student student =(Student)map.get("stu");
			SQL sql=new SQL();
			sql.UPDATE("student");
			if(student.getSname()!=null || "".equals(student.getSname())){
				sql.SET("sname=#{stu.sname}");
			}
			if(student.getAge()!=null||"".equals(student.getAge())){
				sql.SET("age=#{stu.age}");
			}
			if(student.getSex()!=null || "".equals(student.getSex())){
				sql.SET("sex=#{stu.sex}");
			}
			sql.WHERE("sid=#{stu.sid}");
			return sql.toString();
		}
		public String queryStudentByGradeIdSql(Map map){
			List<String> list =(List<String>)map.get("gradeList");
			System.out.println(list);
			SQL sql=new SQL();
			sql.SELECT("*").FROM("student");
			String str="";
			for (String s:list) {
				str+=s+",";
			}
			String st=str.substring(0,str.length()-1);
			sql.WHERE("gid in ("+st+")");
			return sql.toString();
		}
		
		public String insertStudentSql(Map map){
			Student student =(Student)map.get("stu");
			SQL sql=new SQL();
			sql.INSERT_INTO("student");
			if(student.getSid()!=null || "".equals(student.getSid())){
				sql.VALUES("sid", "#{stu.sid}");
			}
			if(student.getSname()!=null || "".equals(student.getSname())){
				sql.VALUES("sname", "#{stu.sname}");
			}
			if(student.getSex()!=null || "".equals(student.getSex())){
				sql.VALUES("sex", "#{stu.sex}");
			}
			if(student.getAge()!=null || "".equals(student.getAge())){
				sql.VALUES("age", "#{stu.age}");
			}
			if(student.getAddress()!=null || "".equals(student.getAddress())){
				sql.VALUES("address", "#{stu.address}");
			}
			return sql.toString();
		}
		
	}
	@SelectProvider(type=StudentProvier.class,method="queryStudentSql1")
	public List<Student> queryStudent(@Param("stu")Student student);
	/**
	 * 通过性别来查
	 */
	@Select("<script>select * from student where 1=1"+
  	"<choose>"+
  	"<when test=\"sex!=null\">"+
  		"and sex=${sex}"+
  	"</when>"+
  	"<otherwise>"+
  		"and sex=1"+
  	"</otherwise>"+
  	"</choose></script>")
	public List<Student> queryBySex(@Param("sex")Integer sex);
	/**
	 * 修改
	 */
	@UpdateProvider(type=StudentProvier.class,method="updateStudentSql")
	public void updateStudent(@Param("stu")Student student);
	/**
	 * 通过班级查询学生
	 */
	@SelectProvider(type=StudentProvier.class,method="queryStudentByGradeIdSql")
	public List<Student> queryStudentByGradeId(@Param("gradeList")List<String> gradeList);
	
	/**
	 * 添加学生
	 */
	@InsertProvider(type=StudentProvier.class,method="insertStudentSql")
	public void insertStudent(@Param("stu")Student student);
}
