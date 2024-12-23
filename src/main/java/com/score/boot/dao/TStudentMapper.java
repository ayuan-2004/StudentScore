package com.score.boot.dao;

import com.score.boot.model.dto.StudentLogin;
import com.score.boot.model.pojo.TStudent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TStudentMapper {
    //登录
    @Select("select * from t_student where student_no=#{student.studentName} and stu_pass=#{student.stuPass}")
    TStudent tologin(@Param("student") StudentLogin studentLogin);
    //查询所有学生信息
}
