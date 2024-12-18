package com.score.boot.service;

import com.score.boot.model.dto.Logindto;
import com.score.boot.model.dto.StudentLogin;
import com.score.boot.model.dto.Studentdtn;
import com.score.boot.model.pojo.TStudent;
import com.score.boot.model.pojo.TUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 用户服务接口
 * @author Yang
 *
 */
@Service
public interface IUserService {
	TUser login(Logindto logindto);
	TStudent tologin(StudentLogin studentLogin);
	//查询
	List<TStudent> selectAll();
	//添加
	int addStudent(Studentdtn studentdtn);
	//修改
	int updateStudent(Studentdtn studentdtn);
}
