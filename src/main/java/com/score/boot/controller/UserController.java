package com.score.boot.controller;


import com.score.boot.model.dto.Logindto;
import com.score.boot.model.dto.StudentLogin;
import com.score.boot.model.dto.Studentdtn;
import com.score.boot.model.pojo.TStudent;
import com.score.boot.model.pojo.TUser;
import com.score.boot.service.IUserService;
import com.score.boot.service.TStudentService;
import com.score.boot.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;

	@Autowired
	private TStudentService studentService;

	//教师登录
	@RequestMapping("/teacherLogin")
	public ResponseUtils<String> login(@RequestBody Logindto logindto){
		try {
				TUser login = userService.login(logindto);
				if (login==null){
					System.out.println(login);
					return new ResponseUtils<>(500,"教师登录失败");
				}else {
					return new ResponseUtils<>(200,"教师登录成功");
				}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	//学生登录
	@RequestMapping("/studentLogin")
	public ResponseUtils<String> stucentLogin(@RequestBody StudentLogin studentLogin){
		try {
			TStudent tologin = userService.tologin(studentLogin);
			if (tologin==null){
				System.out.println(tologin);
				return new ResponseUtils<>(500,"学生登录失败");
			}else {
				return new ResponseUtils<>(200,"学生登录成功");
			}
		}catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	//查询所有学生
	@RequestMapping("/selectAllStudent")
	public ResponseUtils selectAll(){
		try {
			List<TStudent> tStudents = userService.selectAll();
			if (tStudents != null){
				return new ResponseUtils<>(200,"查询成功",tStudents);
			}else {
				return new ResponseUtils<>(503,"查询失败");
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	//添加学生
	@RequestMapping("selectAddStudent")
	public ResponseUtils addStudent(@RequestBody Studentdtn studentdtn){
		try {
			int i = userService.addStudent(studentdtn);
			if (i == 1){
				return new ResponseUtils<>(200,"添加成功");
			}else {
				return new ResponseUtils<>(306,"添加失败");
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	//修改学生信息
	@RequestMapping("updateStudent")
	public ResponseUtils updateStudent(@RequestBody Studentdtn studentdtn){
		try {
			int i = userService.updateStudent(studentdtn);
			if (i == 1){
				return new ResponseUtils<>(200,"修改成功");
			}else {
				return new ResponseUtils<>(305,"修改失败");
			}
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}
