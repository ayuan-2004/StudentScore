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

}
