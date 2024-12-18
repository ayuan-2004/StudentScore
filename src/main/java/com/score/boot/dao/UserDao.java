package com.score.boot.dao;

import com.score.boot.model.dto.StudentLogin;
import com.score.boot.model.dto.Studentdtn;
import com.score.boot.model.pojo.TStudent;
import com.score.boot.model.pojo.TUser;
import com.score.boot.model.dto.Logindto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 用户登录数据层
 * @author hmg
 *
 */
@Mapper //标识为mybatis数据层接口
public interface UserDao {
	//教师登录
	@Select("select * from t_user WHERE user_name = #{logindto.username} AND pass_word = #{logindto.password}")
	TUser login(@Param("logindto") Logindto logindto);
	//学生登录
	@Select("select * from t_student where student_no=#{student.studentName} and stu_pass=#{student.stuPass} and is_delete=0 ")
	TStudent tologin(@Param("student") StudentLogin studentLogin);
	//查询所有学生信息
	@Select("select * from t_student where is_delete=0")
	List<TStudent> selectAll();
	//添加学生信息
	@Insert("insert into t_student value (#{student.studentNo},#{student.studentName},#{student.studentSex},#{student.studentNo},0)")
	int addStudent(@Param("student") Studentdtn studentdtn);
	//修改学生信息
	@Update("update t_student set student_name=#{student.studentName},student_sex=#{student.studentSex} where student_no=#{student.studentNo}")
	int updateStudent(@Param("student") Studentdtn studentdtn);
}
